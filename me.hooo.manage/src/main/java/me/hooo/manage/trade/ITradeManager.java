package me.hooo.manage.trade;

import me.hooo.dao.trade.model.TradeInfoDO;
import me.hooo.dao.trade.model.TradeStockInfoDO;

import java.util.List;

public interface ITradeManager {

    Long addStockInfo(TradeStockInfoDO tradeStockInfoDO);

    List<TradeStockInfoDO> getStockInfoList(List<Integer> stockTypeList);

    TradeStockInfoDO selectStockInfoById(Long id);

    void updateStockInfo(TradeStockInfoDO tradeStockInfoDO);

    void deleteById(Long id);

    List<TradeInfoDO> getTradeInfoList(Integer tradeType, List<Integer> tradeStatusList);
}