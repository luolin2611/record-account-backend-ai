package cn.rollin.passwordassistant.mapper;

import cn.rollin.passwordassistant.pojo.entity.Budget;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

@Mapper
public interface BudgetMapper extends BaseMapper<Budget> {

    /**
     * 获取指定月份的总预算金额
     */
    BigDecimal getMonthBudget(@Param("userId") Long userId, @Param("year") Integer year, @Param("month") Integer month);
}
