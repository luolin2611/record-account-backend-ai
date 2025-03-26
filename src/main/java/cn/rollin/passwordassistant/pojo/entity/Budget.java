package cn.rollin.passwordassistant.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 预算表
 *
 * @author rollin
 * @date 2025-03-25 23:30:19
 */
@Getter
@Setter
@Builder
@TableName("t_budget")
public class Budget implements Serializable {

    /**
     * 预算ID，自增
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户ID，关联t_user表
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 分类ID，关联t_classify表（总预算时为NULL）
     */
    @TableField("classify_id")
    private Long classifyId;

    /**
     * 预算类型：0-总预算，1-分类预算
     */
    @TableField("budget_type")
    private Integer budgetType;

    /**
     * 预算年份
     */
    @TableField("year")
    private Integer year;

    /**
     * 预算月份（1-12）
     */
    @TableField("month")
    private Integer month;

    /**
     * 预算金额
     */
    @TableField("amount")
    private BigDecimal amount;

    /**
     * 创建时间
     */
    @TableField("created_time")
    private LocalDateTime createdTime;

    /**
     * 更新时间
     */
    @TableField("updated_time")
    private LocalDateTime updatedTime;
}
