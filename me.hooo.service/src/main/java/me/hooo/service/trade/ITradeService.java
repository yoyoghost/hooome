package me.hooo.service.trade;

import me.hooo.common.trade.vo.StockTypeVO;

import java.util.List;

public interface ITradeService {
    List<StockTypeVO> getStockTypes();
}
