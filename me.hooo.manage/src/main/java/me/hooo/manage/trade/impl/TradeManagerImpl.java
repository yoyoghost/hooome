package me.hooo.manage.trade.impl;

import me.hooo.common.trade.vo.TradeStockInfoVO;
import me.hooo.dao.trade.mapper.TradeInfoMapper;
import me.hooo.dao.trade.mapper.TradeStockInfoMapper;
import me.hooo.dao.trade.model.TradeInfoDO;
import me.hooo.dao.trade.model.TradeStockInfoDO;
import me.hooo.manage.trade.ITradeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TradeManagerImpl implements ITradeManager {

    @Autowired
    private TradeStockInfoMapper tradeStockInfoMapper;

    @Autowired
    private TradeInfoMapper tradeInfoMapper;

    @Override
    public Long addStockInfo(TradeStockInfoDO tradeStockInfoDO) {
        return tradeStockInfoMapper.insert(tradeStockInfoDO);
    }

    @Override
    public List<TradeStockInfoDO> getStockInfoList(List<Integer> dcStockTypeList) {
        return tradeStockInfoMapper.selectList(dcStockTypeList);
    }

    @Override
    public TradeStockInfoDO selectStockInfoById(Long id) {
        return tradeStockInfoMapper.selectStockInfoById(id);
    }

    @Override
    public void updateStockInfo(TradeStockInfoDO tradeStockInfoDO) {
        tradeStockInfoMapper.updateStockInfo(tradeStockInfoDO);
    }

    @Override
    public void deleteStockInfoById(Long id) {
        tradeStockInfoMapper.deleteById(id);
    }

    @Override
    public List<TradeInfoDO> getTradeInfoList(Integer tradeType, List<Integer> tradeStatusList) {
        return tradeInfoMapper.selectListByTradeType(tradeType, tradeStatusList);
    }

    @Override
    public void addTradeInfo(TradeInfoDO tradeInfoDO) {
        tradeInfoMapper.insert(tradeInfoDO);
    }

    @Override
    public TradeInfoDO selectTradeInfoById(Long id) {
        return tradeInfoMapper.selectTradeInfoById(id);
    }

    @Override
    public void updateTradeInfo(TradeInfoDO tradeInfoDO) {
        tradeInfoMapper.updateTradeInfo(tradeInfoDO);
    }

    @Override
    public void deleteTradeInfoById(Long id) {
        tradeInfoMapper.deleteById(id);
    }
}
