package cn.rollin.passwordassistant.pojo.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class RecordAccountReq {
    
    /**
     * 账单金额
     */
    @NotNull(message = "账单金额不能为空")
    @DecimalMin(value = "0.01", message = "账单金额必须大于0")
    @Digits(integer = 10, fraction = 2, message = "账单金额最多保留两位小数")
    private BigDecimal billMoney;
    
    /**
     * 分类ID
     */
    @NotNull(message = "分类不能为空")
    private Long classifyId;
    
    /**
     * 分类名称
     */
    @NotBlank(message = "分类名称不能为空")
    private String classifyName;
    
    /**
     * 支付类型 (0-支出，1-收入)
     */
    @NotBlank(message = "支付类型不能为空")
    private String classifyType;
    
    /**
     * 记账时间 (yyyy-MM-dd)
     */
    @NotNull(message = "记账时间不能为空")
    private LocalDate recordTime;
    
    /**
     * 描述信息
     */
    private String remark;
} 