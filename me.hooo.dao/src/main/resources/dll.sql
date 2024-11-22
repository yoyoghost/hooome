CREATE TABLE `trade_stock_info` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键，无业务含义',
  `stock_code` varchar(32) NOT NULL DEFAULT '' COMMENT '股票编码',
  `stock_name` varchar(32) NOT NULL DEFAULT '' COMMENT '股票名称',
  `stock_type` tinyint DEFAULT '0' COMMENT '股票类型 1:ETF 2:债券 3:基金 4:股票',
  `stock_minimum_holding_period` int DEFAULT '0' COMMENT '最短持有期 0:不限， 其他',
  `stock_status` tinyint DEFAULT '0' COMMENT '股票状态 0:禁用 1:启用',
  `stock_remark` varchar(512) NOT NULL DEFAULT '' COMMENT '股票备注',
  `create_user` bigint unsigned DEFAULT '0' COMMENT '创建人id',
  `create_user_name` varchar(32) DEFAULT '' COMMENT '创建人姓名',
  `update_user` bigint unsigned DEFAULT '0' COMMENT '更新人id',
  `update_user_name` varchar(32) DEFAULT '' COMMENT '更新人姓名',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `deleted` tinyint unsigned DEFAULT '0' COMMENT '0-未删除 null/1-已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='交易信息';

CREATE TABLE `trade_info` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键，无业务含义',
  `account_id` bigint unsigned NOT NULL DEFAULT '0' COMMENT '用户id',
  `parent_trade_info_id` bigint unsigned NOT NULL DEFAULT '0' COMMENT '用来记录卖出的时候指定卖出的是那一笔买入的订单',
  `stock_id` bigint unsigned NOT NULL COMMENT '股票id',
  `stock_name` bigint unsigned NOT NULL COMMENT '股票名称',
  `trade_date` date DEFAULT NULL COMMENT '交易日期',
  `trade_point` date DEFAULT NULL COMMENT '交易点位',
  `trade_number` int DEFAULT '0' COMMENT '交易数量',
  `trade_amount` double DEFAULT '0' COMMENT '交易金额',
  `trade_type` tinyint DEFAULT '0' COMMENT '1:买入 2:卖出',
  `trade_remaining_number` int DEFAULT '0' COMMENT '交易卖出后剩余数量',
  `trade_status` tinyint DEFAULT '0' COMMENT '交易状态 0:待卖出 1:完成 2:进行中',
  `create_user` bigint unsigned DEFAULT '0' COMMENT '创建人id',
  `create_user_name` varchar(32) DEFAULT '' COMMENT '创建人姓名',
  `update_user` bigint unsigned DEFAULT '0' COMMENT '更新人id',
  `update_user_name` varchar(32) DEFAULT '' COMMENT '更新人姓名',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `deleted` tinyint unsigned DEFAULT '0' COMMENT '0-未删除 null/1-已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='交易信息';