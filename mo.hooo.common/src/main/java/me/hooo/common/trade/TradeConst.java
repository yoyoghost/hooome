package me.hooo.common.trade;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

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

        /**
         * 获取东财支持的股票类型
         * @return 东财支持的股票类型列表
         */
        public static List<Integer> getDCStockType() {
            return Arrays.asList(ETF.getCode(), STOCK.getCode(), FUND.getCode());
        }
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


    @Getter
    @AllArgsConstructor
    public enum TradeTypeEnum {
        // 股票状态 1:正常 2:停牌
        BUY(1, "买入"),
        SELL(2, "卖出"),
        ;

        private final Integer code;
        private final String desc;
    }

    /**
     * 交易状态
     * 交易状态 0:待卖出 1:完成 2:进行中
     */
    @Getter
    @AllArgsConstructor
    public enum TradeStatusEnum {
        BUY_IN(1, "买入"),
        PART_SELL(2, "进行中/部分卖出"),
        ALL_SELL(3, "已完成/全部卖出"),
        ;

        private final Integer code;
        private final String desc;
    }
}
