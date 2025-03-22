package cn.rollin.passwordassistant.mapper;

import cn.rollin.passwordassistant.pojo.entity.RecordAccount;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface RecordAccountMapper extends BaseMapper<RecordAccount> {

    /**
     * 获取指定月份的支出总额
     */
    BigDecimal getMonthExpense(@Param("userId") Long userId, @Param("year") Integer year, @Param("month") Integer month);

    /**
     * 获取指定月份的收入总额
     */
    BigDecimal getMonthIncome(@Param("userId") Long userId, @Param("year") Integer year, @Param("month") Integer month);

    /**
     * 获取近三日的记账记录
     */
    List<RecordAccount> getRecentRecords(@Param("userId") Long userId, @Param("days") Integer days);
}
