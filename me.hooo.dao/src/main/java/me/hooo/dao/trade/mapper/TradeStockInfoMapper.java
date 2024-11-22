package me.hooo.dao.trade.mapper;

import me.hooo.dao.trade.model.TradeStockInfoDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TradeStockInfoMapper {
    int insert(TradeStockInfoDO tradeStockInfoDO);
}
