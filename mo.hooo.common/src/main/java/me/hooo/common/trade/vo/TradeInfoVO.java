package me.hooo.common.trade.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import me.hooo.common.util.CustomDateSerializer;

import java.util.Date;

@Data
public class TradeInfoVO {
    private Long id; // 自增主键，无业务含义
    private Long accountId; // 用户id
    private Long parentTradeInfoId; // 用来记录卖出的时候指定卖出的是那一笔买入的订单
    private Long stockId; // 股票id
    private String stockName; // 股票名称
    @JsonSerialize(using = CustomDateSerializer.class)
    private Date tradeDate; // 交易日期
    private Integer tradePoint; // 交易点位
    private Integer tradeNumber; // 交易数量
    private Double tradeAmount; // 交易金额
    private Integer tradeType; // 1:买入 2:卖出
    private Integer tradeRemainingNumber; // 交易卖出后剩余数量
    private Integer tradeStatus; // 交易状态 0:待卖出 1:完成 2:进行中
    private Date createTime; // 创建时间
    private Date updateTime; // 修改时间当作最终时间使用
    private Integer isCanEdit; // 是否可以编辑 0:不可以 1:可以  是否可以删除 0:不可以 1:可以
}