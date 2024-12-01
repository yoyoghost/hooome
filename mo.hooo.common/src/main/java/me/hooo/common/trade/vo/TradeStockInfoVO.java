package me.hooo.common.trade.vo;

import lombok.Data;

@Data
public class TradeStockInfoVO {
    private Long id; // 自增主键，无业务含义
    private String stockCode; // 股票编码
    private String stockName; // 股票名称
    private Integer stockType; // 股票类型 1:ETF 2:债券 3:基金 4:股票
    private Integer stockMinimumHoldingPeriod; // 最短持有期 0:不限， 其他
    private Integer stockStatus; // 股票状态 0:禁用 1:启用
    private String stockRemark; // 股票备注
}