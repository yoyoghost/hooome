package me.hooo.dao.trade.model;

import lombok.Data;

import java.util.Date;

@Data
public class TradeStockInfoDO {
    private Long id; // 自增主键，无业务含义
    private String stockCode; // 股票编码
    private String stockName; // 股票名称
    private Integer stockType; // 股票类型 1:ETF 2:债券 3:基金 4:股票
    private Integer stockMinimumHoldingPeriod; // 最短持有期 0:不限， 其他
    private Integer stockStatus; // 股票状态 0:禁用 1:启用
    private String stockRemark; // 股票备注
    private Long createUser; // 创建人id
    private String createUserName; // 创建人姓名
    private Long updateUser; // 更新人id
    private String updateUserName; // 更新人姓名
    private Date createTime; // 记录创建时间
    private Date updateTime; // 修改时间
    private Integer deleted; // 0-未删除 null/1-已删除
}