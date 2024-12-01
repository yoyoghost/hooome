package me.hooo.manage.trade.impl;

import me.hooo.common.trade.vo.TradeStockInfoVO;
import me.hooo.dao.trade.mapper.TradeInfoMapper;
import me.hooo.dao.trade.mapper.TradeStockInfoMapper;
import me.hooo.dao.trade.model.TradeStockInfoDO;
import me.hooo.manage.trade.ITradeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TradeManagerImpl implements ITradeManager {

    @Autowired
    private TradeStockInfoMapper tradeStockInfoMapper;

    @Override
    public Long addStockInfo(TradeStockInfoDO tradeStockInfoDO) {
        return tradeStockInfoMapper.insert(tradeStockInfoDO);
    }

    @Override
    public List<TradeStockInfoDO> getStockInfoList() {
        return tradeStockInfoMapper.selectList();
    }
}
