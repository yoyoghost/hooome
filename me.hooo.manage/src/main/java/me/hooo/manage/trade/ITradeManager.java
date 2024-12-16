package me.hooo.manage.trade;

import me.hooo.dao.trade.model.TradeInfoDO;
import me.hooo.dao.trade.model.TradeStockInfoDO;

import java.util.List;

public interface ITradeManager {

    Long addStockInfo(TradeStockInfoDO tradeStockInfoDO);

    List<TradeStockInfoDO> getStockInfoList(List<Integer> stockTypeList);

    TradeStockInfoDO selectStockInfoById(Long id);

    void updateStockInfo(TradeStockInfoDO tradeStockInfoDO);

    void deleteStockInfoById(Long id);

    List<TradeInfoDO> getTradeInfoList(Integer tradeType, List<Integer> tradeStatusList);

    void addTradeInfo(TradeInfoDO tradeInfoDO);

    TradeInfoDO selectTradeInfoById(Long id);

    void updateTradeInfo(TradeInfoDO tradeInfoDO);

    void deleteTradeInfoById(Long id);
}