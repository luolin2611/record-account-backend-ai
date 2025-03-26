package cn.rollin.passwordassistant.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.rollin.passwordassistant.common.enums.ResStatusEnum;
import cn.rollin.passwordassistant.common.exception.BizException;
import cn.rollin.passwordassistant.common.res.Response;
import cn.rollin.passwordassistant.mapper.BudgetMapper;
import cn.rollin.passwordassistant.mapper.ClassifyMapper;
import cn.rollin.passwordassistant.mapper.RecordAccountMapper;
import cn.rollin.passwordassistant.pojo.dto.HomeStatisticsRes;
import cn.rollin.passwordassistant.pojo.dto.RecordAccountReq;
import cn.rollin.passwordassistant.pojo.entity.Classify;
import cn.rollin.passwordassistant.pojo.entity.RecordAccount;
import cn.rollin.passwordassistant.service.IHomeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class HomeServiceImpl implements IHomeService {

    @Autowired
    private RecordAccountMapper recordAccountMapper;

    @Autowired
    private ClassifyMapper classifyMapper;

    @Autowired
    private BudgetMapper budgetMapper;

    @Override
    public Response<HomeStatisticsRes> getHomeStatistics(Long userId) {
        LocalDate now = LocalDate.now();
        int year = now.getYear();
        int month = now.getMonthValue();

        // 获取本月支出
        BigDecimal monthExpense = recordAccountMapper.getMonthExpense(userId, year, month);
        monthExpense = monthExpense == null ? BigDecimal.ZERO : monthExpense;

        // 获取本月收入
        BigDecimal monthIncome = recordAccountMapper.getMonthIncome(userId, year, month);
        monthIncome = monthIncome == null ? BigDecimal.ZERO : monthIncome;

        // 获取本月预算
        BigDecimal monthBudget = budgetMapper.getMonthBudget(userId, year, month);
        monthBudget = monthBudget == null ? BigDecimal.ZERO : monthBudget;

        // 计算预算超支
        BigDecimal budgetOverspend = BigDecimal.ZERO;
        if (monthBudget.compareTo(BigDecimal.ZERO) > 0) {
            budgetOverspend = monthExpense.subtract(monthBudget);
            if (budgetOverspend.compareTo(BigDecimal.ZERO) < 0) {
                budgetOverspend = BigDecimal.ZERO;
            }
        }

        // 获取近三日记账记录
        List<RecordAccount> recentRecords = recordAccountMapper.getRecentRecords(userId, 3);

        // 按日期分组并按日期逆序排序
        Map<String, List<RecordAccount>> recordsByDate = recentRecords.stream()
                .collect(Collectors.groupingBy(
                    record -> record.getRecordTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                    () -> new TreeMap<String, List<RecordAccount>>(Comparator.reverseOrder()),
                    Collectors.toList()
                ));

        // 构建返回数据
        List<HomeStatisticsRes.DailyRecordGroup> dailyGroups = new ArrayList<>();
        recordsByDate.forEach((date, records) -> {
            HomeStatisticsRes.DailyRecordGroup group = new HomeStatisticsRes.DailyRecordGroup();
            group.setDate(date);

            // 确保每个日期内的记录也是按时间逆序排序
            List<HomeStatisticsRes.RecordDetail> details = records.stream()
                    .sorted(Comparator.comparing(RecordAccount::getRecordTime).reversed())
                    .map(record -> {
                        HomeStatisticsRes.RecordDetail detail = new HomeStatisticsRes.RecordDetail();
                        detail.setId(record.getId());
                        detail.setClassifyId(record.getClassifyId());
                        detail.setClassifyName(record.getClassifyName());
                        detail.setAmount(record.getBillMoney());
                        detail.setClassifyType(record.getClassifyType());
                        detail.setIconName(record.getIconName());
                        detail.setRemark(record.getRemark());
                        return detail;
                    })
                    .collect(Collectors.toList());
            group.setRecords(details);
            dailyGroups.add(group);
        });

        // 构建响应对象
        HomeStatisticsRes response = new HomeStatisticsRes();
        response.setMonthExpense(monthExpense);
        response.setMonthIncome(monthIncome);
        response.setMonthBudget(monthBudget);
        response.setBudgetOverspend(budgetOverspend);
        response.setRecentRecords(dailyGroups);

        return Response.buildSuccess(response);
    }

    @Override
    public Response<Object> recordAccount(Long userId, RecordAccountReq req) {
        // 创建记账记录
        RecordAccount record = new RecordAccount();
        record.setUserId(userId);
        record.setBillMoney(req.getBillMoney().setScale(2, BigDecimal.ROUND_HALF_UP));
        Long classifyId = req.getClassifyId();
        Classify classify = classifyMapper.selectById(classifyId);
        if (ObjectUtil.isEmpty(classify)) {
            throw new BizException(ResStatusEnum.CATEGORY_NOT_FOUND);
        }
        record.setClassifyId(classifyId);
        record.setClassifyName(classify.getClassifyName());
        record.setClassifyType(classify.getAddType());
        record.setRemark(req.getRemark());
        record.setRecordTime(LocalDateTime.now());
        record.setUpdatedTime(LocalDateTime.now());
        // 保存记录
        recordAccountMapper.insert(record);

        return Response.buildSuccess();
    }
}
