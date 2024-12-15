package me.hooo.dao.trade.mapper;

import me.hooo.dao.trade.model.TradeInfoDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TradeInfoMapper {
    int insert(TradeInfoDO tradeInfo);

    List<TradeInfoDO> selectListByTradeType(@Param("tradeType") Integer tradeType, @Param("tradeStatusList") List<Integer> tradeStatusList);
}