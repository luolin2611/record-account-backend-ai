package cn.rollin.passwordassistant.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 分类表
 *
 * @author rollin
 * @date 2025-03-25 23:31:46
 */
@Getter
@Setter
@Builder
@TableName("t_classify")
public class Classify implements Serializable {

    /**
     * 分类id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 分类名称
     */
    @TableField("classify_name")
    private String classifyName;

    /**
     * 支付类型 (0-支出，1-收入)
     */
    @TableField("type")
    private String type;

    /**
     * 分类类型 (0-预设，1-用户新增)
     */
    @TableField("add_type")
    private String addType;

    /**
     * 图标名称
     */
    @TableField("icon_name")
    private String iconName;

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
