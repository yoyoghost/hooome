package me.hooo.common.trade.vo;

import lombok.Builder;
import lombok.Data;

/**
 * 股票类型
 */
@Builder
@Data
public class StockTypeVO {
    private int code;
    private String desc;
}
