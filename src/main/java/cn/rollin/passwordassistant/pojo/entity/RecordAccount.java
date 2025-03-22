package cn.rollin.passwordassistant.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("t_record_account")
public class RecordAccount {
    
    @TableId(type = IdType.AUTO)
    private Long id;
    
    private BigDecimal billMoney;
    
    private Long classifyId;
    
    private String classifyName;
    
    private String classifyType;
    
    private Long userId;
    
    private String remark;
    
    private String iconName;
    
    private LocalDateTime recordTime;
    
    private LocalDateTime updatedTime;
} 
