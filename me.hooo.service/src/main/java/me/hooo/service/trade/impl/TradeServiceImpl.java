package me.hooo.service.trade.impl;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import me.hooo.common.trade.TradeConst;
import me.hooo.common.trade.vo.StockTypeVO;
import me.hooo.service.trade.ITradeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TradeServiceImpl implements ITradeService {
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
}
