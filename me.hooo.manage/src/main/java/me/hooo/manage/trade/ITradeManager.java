package me.hooo.manage.trade;

import me.hooo.dao.trade.model.TradeStockInfoDO;

import java.util.List;

public interface ITradeManager {

    Long addStockInfo(TradeStockInfoDO tradeStockInfoDO);

    List<TradeStockInfoDO> getStockInfoList();

    TradeStockInfoDO selectStockInfoById(Long id);

    void updateStockInfo(TradeStockInfoDO tradeStockInfoDO);

    void deleteById(Long id);
}