package me.hooo.dao.trade.mapper;

import me.hooo.dao.trade.model.TradeStockInfoDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TradeStockInfoMapper {
    Long insert(TradeStockInfoDO tradeStockInfoDO);

    List<TradeStockInfoDO> selectList(List<Integer> dcStockTypeList);

    TradeStockInfoDO selectStockInfoById(Long id);

    void updateStockInfo(TradeStockInfoDO tradeStockInfoDO);

    void deleteById(Long id);
}
