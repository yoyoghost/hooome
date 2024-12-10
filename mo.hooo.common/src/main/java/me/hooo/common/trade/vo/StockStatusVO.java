package me.hooo.common.trade.vo;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StockStatusVO {
    private int code;
    private String desc;
}
