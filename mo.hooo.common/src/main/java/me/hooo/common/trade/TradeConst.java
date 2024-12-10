package me.hooo.common.trade;

import lombok.AllArgsConstructor;
import lombok.Getter;

public interface TradeConst {

    @Getter
    @AllArgsConstructor
    public enum StockTypeEnum {
        // 股票类型 1:ETF 2:债券 3:基金 4:股票
        ETF(1, "ETF"),
        DEBT(2, "债权"),
        FUND(3, "基金"),
        STOCK(4, "股票"),
        ;

        private final Integer code;
        private final String desc;
    }

    @Getter
    @AllArgsConstructor
    public enum StockStatusEnum {
        // 股票状态 1:正常 2:停牌
        ENABLE(1, "正常"),
        DISABLE(2, "清仓"),
        ;

        private final Integer code;
        private final String desc;
    }
}
