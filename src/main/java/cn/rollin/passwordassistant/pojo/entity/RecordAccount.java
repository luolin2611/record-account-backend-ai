package cn.rollin.passwordassistant.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 记账表
 *
 * @author rollin
 * @date 2025-03-25 23:30:44
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_record_account")
public class RecordAccount implements Serializable {

    /**
     * 记账ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 账单金额
     */
    @TableField("bill_money")
    private BigDecimal billMoney;

    /**
     * 分类ID
     */
    @TableField("classify_id")
    private Long classifyId;

    /**
     * 分类名称
     */
    @TableField("classify_name")
    private String classifyName;

    /**
     * 支付类型 (0-支出，1-收入)
     */
    @TableField("classify_type")
    private String classifyType;

    /**
     * 用户ID
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 描述信息
     */
    @TableField("remark")
    private String remark;

    /**
     * 图标名称
     */
    @TableField("icon_name")
    private String iconName;

    /**
     * 记账时间
     */
    @TableField("record_time")
    private LocalDateTime recordTime;

    /**
     * 更新时间
     */
    @TableField("updated_time")
    private LocalDateTime updatedTime;
}
