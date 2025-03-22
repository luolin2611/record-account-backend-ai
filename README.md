# 记账啦

# 1.概述

# 2.数据库



## 2.1 用户表(t_user)

```sql
-- ----------------------------
-- Table structure for t_user
-- ----------------------------

DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID，自增',
  `username` varchar(64) NOT NULL COMMENT '用户名',
  `email` varchar(64) NOT NULL COMMENT '电子邮件地址',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `salt` varchar(64) NOT NULL COMMENT '密码盐值',
  `signature` varchar(256) DEFAULT NULL COMMENT '个性签名',
  `status` varchar(1) DEFAULT '0' COMMENT '用户状态： 0-在用,1-无效',
  `avatar_url` varchar(1024) DEFAULT NULL COMMENT '头像',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_username` (`username`),
  UNIQUE KEY `idx_email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;
```



## 2.2 分类表（t_classify）

```sql
-- ----------------------------
-- Table structure for t_classify
-- ----------------------------
DROP TABLE IF EXISTS `t_classify`;
CREATE TABLE `t_classify` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '分类id',
  `classify_name` varchar(20) DEFAULT NULL COMMENT '分类名称',
  `type` varchar(1) DEFAULT NULL COMMENT '支付类型 (0-支出，1-收入)',
  `add_type` varchar(1) DEFAULT NULL COMMENT '分类类型 (0-预设，1-用户新增)',
  `icon_name` varchar(50) DEFAULT NULL COMMENT '图标名称',
  `created_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_classify
-- ----------------------------
BEGIN;
INSERT INTO `t_classify` (`id`, `classify_name`, `type`, `add_type`, `icon_name`, `updated_time`, `created_time`) VALUES (1, '餐饮', '0', '0', 'canyin', '2025-03-22 23:31:28', '2025-03-22 23:31:28');
INSERT INTO `t_classify` (`id`, `classify_name`, `type`, `add_type`, `icon_name`, `updated_time`, `created_time`) VALUES (2, '零食烟酒', '0', '0', 'yanjiulingshi', '2025-03-22 23:31:38', '2025-03-22 23:31:38');
INSERT INTO `t_classify` (`id`, `classify_name`, `type`, `add_type`, `icon_name`, `updated_time`, `created_time`) VALUES (3, '购物', '0', '0', 'gouwu', '2025-03-22 23:31:46', '2025-03-22 23:31:46');
INSERT INTO `t_classify` (`id`, `classify_name`, `type`, `add_type`, `icon_name`, `updated_time`, `created_time`) VALUES (4, '住房', '0', '0', 'zhufang', '2025-03-22 23:31:51', '2025-03-22 23:31:51');
INSERT INTO `t_classify` (`id`, `classify_name`, `type`, `add_type`, `icon_name`, `updated_time`, `created_time`) VALUES (5, '交通', '0', '0', 'jiaotong', '2025-03-22 23:31:57', '2025-03-22 23:31:57');
INSERT INTO `t_classify` (`id`, `classify_name`, `type`, `add_type`, `icon_name`, `updated_time`, `created_time`) VALUES (6, '娱乐', '0', '0', 'yule', '2025-03-22 23:31:59', '2025-03-22 23:31:59');
INSERT INTO `t_classify` (`id`, `classify_name`, `type`, `add_type`, `icon_name`, `updated_time`, `created_time`) VALUES (7, '文教', '0', '0', 'wenjiao', '2025-03-22 23:32:03', '2025-03-22 23:32:03');
INSERT INTO `t_classify` (`id`, `classify_name`, `type`, `add_type`, `icon_name`, `updated_time`, `created_time`) VALUES (8, '汽车', '0', '0', 'qiche', '2025-03-22 23:32:10', '2025-03-22 23:32:10');
INSERT INTO `t_classify` (`id`, `classify_name`, `type`, `add_type`, `icon_name`, `updated_time`, `created_time`) VALUES (9, '通讯', '0', '0', 'tongxun', '2025-03-22 23:32:14', '2025-03-22 23:32:14');
INSERT INTO `t_classify` (`id`, `classify_name`, `type`, `add_type`, `icon_name`, `updated_time`, `created_time`) VALUES (10, '育儿', '0', '0', 'yuer', '2025-03-22 23:32:22', '2025-03-22 23:32:22');
INSERT INTO `t_classify` (`id`, `classify_name`, `type`, `add_type`, `icon_name`, `updated_time`, `created_time`) VALUES (11, '人情', '0', '0', 'renqing', '2025-03-22 23:32:25', '2025-03-22 23:32:25');
INSERT INTO `t_classify` (`id`, `classify_name`, `type`, `add_type`, `icon_name`, `updated_time`, `created_time`) VALUES (12, '医疗', '0', '0', 'yiliao', '2025-03-22 23:32:29', '2025-03-22 23:32:29');
INSERT INTO `t_classify` (`id`, `classify_name`, `type`, `add_type`, `icon_name`, `updated_time`, `created_time`) VALUES (13, '旅行', '0', '0', 'lvxing', '2025-03-22 23:32:33', '2025-03-22 23:32:33');
INSERT INTO `t_classify` (`id`, `classify_name`, `type`, `add_type`, `icon_name`, `updated_time`, `created_time`) VALUES (14, '投资', '0', '0', 'touzi', '2025-03-22 23:32:36', '2025-03-22 23:32:36');
INSERT INTO `t_classify` (`id`, `classify_name`, `type`, `add_type`, `icon_name`, `updated_time`, `created_time`) VALUES (15, '投资亏损', '0', '0', 'touzikuisun', '2025-03-22 23:32:41', '2025-03-22 23:32:41');
INSERT INTO `t_classify` (`id`, `classify_name`, `type`, `add_type`, `icon_name`, `updated_time`, `created_time`) VALUES (16, '借出', '0', '0', 'jiechu', '2025-03-22 23:32:44', '2025-03-22 23:32:44');
INSERT INTO `t_classify` (`id`, `classify_name`, `type`, `add_type`, `icon_name`, `updated_time`, `created_time`) VALUES (17, '还债', '0', '0', 'huanzhai', '2025-03-22 23:32:48', '2025-03-22 23:32:48');
INSERT INTO `t_classify` (`id`, `classify_name`, `type`, `add_type`, `icon_name`, `updated_time`, `created_time`) VALUES (18, '利息支出', '0', '0', 'lixizhichu', '2025-03-22 23:32:55', '2025-03-22 23:32:55');
INSERT INTO `t_classify` (`id`, `classify_name`, `type`, `add_type`, `icon_name`, `updated_time`, `created_time`) VALUES (19, '其它', '0', '0', 'qita', '2025-03-22 23:32:58', '2025-03-22 23:32:58');
INSERT INTO `t_classify` (`id`, `classify_name`, `type`, `add_type`, `icon_name`, `updated_time`, `created_time`) VALUES (20, '设置', '0', '0', 'shezhi-zhichu', '2025-03-22 23:33:03', '2025-03-22 23:33:03');
INSERT INTO `t_classify` (`id`, `classify_name`, `type`, `add_type`, `icon_name`, `updated_time`, `created_time`) VALUES (21, '薪资', '1', '0', 'xinzi', '2025-03-22 23:33:19', '2025-03-22 23:33:19');
INSERT INTO `t_classify` (`id`, `classify_name`, `type`, `add_type`, `icon_name`, `updated_time`, `created_time`) VALUES (22, '奖金', '1', '0', 'jiangjin', '2025-03-22 23:33:23', '2025-03-22 23:33:23');
INSERT INTO `t_classify` (`id`, `classify_name`, `type`, `add_type`, `icon_name`, `updated_time`, `created_time`) VALUES (23, '借入', '1', '0', 'jinru', '2025-03-22 23:33:25', '2025-03-22 23:33:25');
INSERT INTO `t_classify` (`id`, `classify_name`, `type`, `add_type`, `icon_name`, `updated_time`, `created_time`) VALUES (24, '收债', '1', '0', 'shouzhai', '2025-03-22 23:33:28', '2025-03-22 23:33:28');
INSERT INTO `t_classify` (`id`, `classify_name`, `type`, `add_type`, `icon_name`, `updated_time`, `created_time`) VALUES (25, '利息收入', '1', '0', 'lixishouru', '2025-03-22 23:33:32', '2025-03-22 23:33:32');
INSERT INTO `t_classify` (`id`, `classify_name`, `type`, `add_type`, `icon_name`, `updated_time`, `created_time`) VALUES (26, '投资回收', '1', '0', 'touzihuishou', '2025-03-22 23:33:36', '2025-03-22 23:33:36');
INSERT INTO `t_classify` (`id`, `classify_name`, `type`, `add_type`, `icon_name`, `updated_time`, `created_time`) VALUES (27, '投资收益', '1', '0', 'touzishouyi', '2025-03-22 23:33:42', '2025-03-22 23:33:42');
INSERT INTO `t_classify` (`id`, `classify_name`, `type`, `add_type`, `icon_name`, `updated_time`, `created_time`) VALUES (28, '报销收入', '1', '0', 'baoxiaoshouru', '2025-03-22 23:33:46', '2025-03-22 23:33:46');
INSERT INTO `t_classify` (`id`, `classify_name`, `type`, `add_type`, `icon_name`, `updated_time`, `created_time`) VALUES (29, '退款', '1', '0', 'tuikuan', '2025-03-22 23:33:49', '2025-03-22 23:33:49');
INSERT INTO `t_classify` (`id`, `classify_name`, `type`, `add_type`, `icon_name`, `updated_time`, `created_time`) VALUES (30, '意外所得', '1', '0', 'yiwaisuode', '2025-03-22 23:34:02', '2025-03-22 23:34:02');
INSERT INTO `t_classify` (`id`, `classify_name`, `type`, `add_type`, `icon_name`, `updated_time`, `created_time`) VALUES (31, '其他收入', '1', '0', 'qitashouru', '2025-03-22 23:34:06', '2025-03-22 23:34:06');
INSERT INTO `t_classify` (`id`, `classify_name`, `type`, `add_type`, `icon_name`, `updated_time`, `created_time`) VALUES (32, '设置', '1', '0', 'shezhi-shouru', '2025-03-22 23:34:16', '2025-03-22 23:34:16');
```

## 2.3 记账表(t_record_account)

```sql
-- ----------------------------
-- Table structure for t_record_account
-- ----------------------------
DROP TABLE IF EXISTS `t_record_account`;
CREATE TABLE `t_record_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '记账ID',
  `bill_money` varchar(20) DEFAULT NULL COMMENT '账单金额',
  `classify_id` bigint(20) DEFAULT NULL COMMENT '分类ID',
  `classify_name` varchar(20) DEFAULT NULL COMMENT '分类名称',
  `classify_type` varchar(1) DEFAULT NULL COMMENT '支付类型 (0-支出，1-收入)',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `remark` varchar(255) DEFAULT NULL COMMENT '描述信息',
  `record_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '记账时间',
  `updated_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`record_account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3101 DEFAULT CHARSET=utf8;
```

## 2.4 预算表

```sql
-- ----------------------------
-- Table structure for t_budget
-- ----------------------------
DROP TABLE IF EXISTS `t_budget`;
CREATE TABLE `t_budget` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '预算ID，自增',
  `user_id` int(11) NOT NULL COMMENT '用户ID，关联t_user表',
  `classify_id` int(11) DEFAULT NULL COMMENT '分类ID，关联t_classify表（总预算时为NULL）',
  `budget_type` tinyint(1) NOT NULL COMMENT '预算类型：0-总预算，1-分类预算',
  `year` int(4) NOT NULL COMMENT '预算年份',
  `month` int(2) NOT NULL COMMENT '预算月份（1-12）',
  `amount` decimal(10,2) NOT NULL COMMENT '预算金额',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_user_budget` (`user_id`, `year`, `month`, `classify_id`),
  KEY `idx_user_id` (`user_id`),
  KEY `idx_classify_id` (`classify_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
```





# 3.接口信息

3.1 首页查询接口

本月支出、本月收入、预算金额、近三日新增记录









# 3.平台依赖环境信息

3.1 依赖Redis

3.2 依赖minio

3.3 依赖mysql







4.AI 使用技巧

4.1 后端生成接口代码

前置内容准备

Deepseek完成

1.使用Deepseek根据需求文档，生成数据库表。

2.









1.先开发一套模板(Controller、Service、Mapper.xml)，AI选择核心文件

2.根据现有的模板导出接口，提供接口给AI作为接口模板

3.使用Deepseek设计的表，提供给AI

4.描述表的关联关系

5.根据内容生成，生成接口AI





数据库表生成流程

![image-20250322095424294](./assets/image-20250322095424294.png)

接口设计流程

![image-20250322095523464](./assets/image-20250322095523464.png)















