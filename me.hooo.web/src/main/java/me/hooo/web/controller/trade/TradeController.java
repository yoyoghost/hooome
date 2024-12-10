package me.hooo.web.controller.trade;

import lombok.extern.slf4j.Slf4j;
import me.hooo.common.HooomeResponse;
import me.hooo.common.trade.vo.StockStatusVO;
import me.hooo.common.trade.vo.StockTypeVO;
import me.hooo.common.trade.vo.TradeStockInfoVO;
import me.hooo.service.trade.ITradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("trade")
public class TradeController {

    @Autowired
    ITradeService tradeService;

    /**
     * 获取股票类型信息
     */
    @PostMapping("getStockType")
    public HooomeResponse<List<StockTypeVO>> getStockTypes() {
        List<StockTypeVO> stockTypeVOList = tradeService.getStockTypes();
        return HooomeResponse.success(stockTypeVOList);
    }

    @PostMapping("getStockStatus")
    public HooomeResponse<List<StockStatusVO>> getStockStatus() {
        List<StockStatusVO> stockStatusVOList = tradeService.getStockStatus();
        return HooomeResponse.success(stockStatusVOList);
    }

    @PostMapping("addStockInfo")
    public HooomeResponse<TradeStockInfoVO> addStockInfo(@RequestBody TradeStockInfoVO tradeStockInfoVO) {
        TradeStockInfoVO tradeStockInfo = tradeService.addStockInfo(tradeStockInfoVO);
        return HooomeResponse.success(tradeStockInfo);
    }

    /**
     * 获取股票信息列表
     */
    @PostMapping("getStockInfoList")
    public HooomeResponse<List<TradeStockInfoVO>> getStockInfoList() {
        List<TradeStockInfoVO> tradeStockInfoVOList = tradeService.getStockInfoList();
        log.info("getStockInfoList:{}", tradeStockInfoVOList);
        return HooomeResponse.success(tradeStockInfoVOList);
    }
}
