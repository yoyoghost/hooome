package me.hooo.service.trade;

import me.hooo.common.trade.vo.StockStatusVO;
import me.hooo.common.trade.vo.StockTypeVO;
import me.hooo.common.trade.vo.TradeInfoVO;
import me.hooo.common.trade.vo.TradeStockInfoVO;

import java.util.List;

public interface ITradeService {
    /**
     * 获取股票类型
     * @return
     */
    List<StockTypeVO> getStockTypes();

    /**
     * 增加股票信息
     * @param tradeStockInfoVO
     * @return
     */
    TradeStockInfoVO addStockInfo(TradeStockInfoVO tradeStockInfoVO);

    /**
     * 获取股票信息列表
     * @return
     */
    List<TradeStockInfoVO> getStockInfoList();

    List<StockStatusVO> getStockStatus();

    TradeStockInfoVO editStockInfo(TradeStockInfoVO tradeStockInfoVO);

    TradeStockInfoVO delStockInfo(TradeStockInfoVO tradeStockInfoVO);

    List<TradeStockInfoVO> getDCStockInfoList();

    /**
     * 获取交易信息列表
     * @return
     */
    List<TradeInfoVO> getTradeInfoList();
}
