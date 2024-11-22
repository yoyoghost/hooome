package me.hooo.dao.trade.mapper;

import me.hooo.dao.trade.model.TradeInfoDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TradeInfoMapper {
    int insert(TradeInfoDO tradeInfo);
}