package cn.rollin.passwordassistant.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("t_budget")
public class Budget {
    
    @TableId(type = IdType.AUTO)
    private Long id;
    
    private Long userId;
    
    private Long classifyId;
    
    private Integer budgetType;
    
    private Integer year;
    
    private Integer month;
    
    private BigDecimal amount;
    
    private LocalDateTime createdTime;
    
    private LocalDateTime updatedTime;
} 
