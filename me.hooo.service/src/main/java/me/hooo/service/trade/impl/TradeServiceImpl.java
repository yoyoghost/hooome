package me.hooo.service.trade.impl;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import me.hooo.common.trade.TradeConst;
import me.hooo.common.trade.vo.StockTypeVO;
import me.hooo.common.trade.vo.TradeStockInfoVO;
import me.hooo.dao.trade.model.TradeStockInfoDO;
import me.hooo.manage.trade.ITradeManager;
import me.hooo.service.trade.ITradeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Slf4j
@Service
public class TradeServiceImpl implements ITradeService {

    @Autowired
    ITradeManager tradeManager;

    @Override
    public List<StockTypeVO> getStockTypes() {
        TradeConst.StockTypeEnum[] values = TradeConst.StockTypeEnum.values();
        List<StockTypeVO> list = Lists.newArrayList();
        for (TradeConst.StockTypeEnum value : values) {
            list.add(StockTypeVO.builder().code(value.getCode()).desc(value.getDesc()).build());
        }
        log.info("getStockTypes:{}", list);
        return list;
    }

    @Override
    public TradeStockInfoVO addStockInfo(TradeStockInfoVO tradeStockInfoVO) {
        // 新增 TradeStockInfo 到数据库
        log.info("addStockInfo:{}", tradeStockInfoVO);
        TradeStockInfoDO tradeStockInfoDO = new TradeStockInfoDO();
        BeanUtils.copyProperties(tradeStockInfoVO, tradeStockInfoDO);
        tradeStockInfoDO.setStockStatus(TradeConst.StockStatusEnum.ENABLE.getCode());
        tradeManager.addStockInfo(tradeStockInfoDO);
        tradeStockInfoVO.setId(tradeStockInfoDO.getId());
        return tradeStockInfoVO;
    }

    @Override
    public List<TradeStockInfoVO> getStockInfoList() {
        List<TradeStockInfoDO> stockInfoList = tradeManager.getStockInfoList();
        if (CollectionUtils.isEmpty(stockInfoList)) {
            return Lists.newArrayList();
        }
        List<TradeStockInfoVO> list = Lists.newArrayList();
        for (TradeStockInfoDO tradeStockInfoDO : stockInfoList) {
            TradeStockInfoVO vo = new TradeStockInfoVO();
            BeanUtils.copyProperties(tradeStockInfoDO, vo);
            list.add(vo);
        }
        return list;
    }
}
