package cn.rollin.passwordassistant.pojo.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

@Data
public class HomeStatisticsRes {
    
    /**
     * 本月支出
     */
    private BigDecimal monthExpense;
    
    /**
     * 本月收入
     */
    private BigDecimal monthIncome;
    
    /**
     * 本月预算
     */
    private BigDecimal monthBudget;
    
    /**
     * 预算超支
     */
    private BigDecimal budgetOverspend;
    
    /**
     * 近三日账单记录
     */
    private List<DailyRecordGroup> recentRecords;
    
    @Data
    public static class DailyRecordGroup {
        /**
         * 日期
         */
        private String date;
        
        /**
         * 当日记录列表
         */
        private List<RecordDetail> records;
    }
    
    @Data
    public static class RecordDetail {
        /**
         * 记账ID
         */
        private Long id;
        
        /**
         * 分类ID
         */
        private Long classifyId;
        
        /**
         * 分类名称
         */
        private String classifyName;
        
        /**
         * 金额
         */
        private BigDecimal amount;
        
        /**
         * 类型(0-支出，1-收入)
         */
        private String classifyType;
        
        /**
         * 图标名称
         */
        private String iconName;
        
        /**
         * 备注
         */
        private String remark;
    }
} 