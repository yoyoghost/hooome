package me.hooo.web.controller.trade;

import lombok.extern.slf4j.Slf4j;
import me.hooo.common.HooomeResponse;
import me.hooo.common.trade.vo.StockStatusVO;
import me.hooo.common.trade.vo.StockTypeVO;
import me.hooo.common.trade.vo.TradeInfoVO;
import me.hooo.common.trade.vo.TradeStockInfoVO;
import me.hooo.service.trade.ITradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 交易信息接口
 */
@Slf4j
@RestController
@RequestMapping("trade/trade")
public class TradeInfoController {

    @Autowired
    ITradeService tradeService;

    @PostMapping("addStockInfo")
    public HooomeResponse<TradeStockInfoVO> addStockInfo(@RequestBody TradeStockInfoVO tradeStockInfoVO) {
        TradeStockInfoVO tradeStockInfo = tradeService.addStockInfo(tradeStockInfoVO);
        return HooomeResponse.success(tradeStockInfo);
    }

    @PostMapping("editStockInfo")
    public HooomeResponse<TradeStockInfoVO> editStockInfo(@RequestBody TradeStockInfoVO tradeStockInfoVO) {
        TradeStockInfoVO tradeStockInfo = tradeService.editStockInfo(tradeStockInfoVO);
        return HooomeResponse.success(tradeStockInfo);
    }

    @PostMapping("delStockInfo")
    public HooomeResponse<TradeStockInfoVO> delStockInfo(@RequestBody TradeStockInfoVO tradeStockInfoVO) {
        TradeStockInfoVO tradeStockInfo = tradeService.delStockInfo(tradeStockInfoVO);
        return HooomeResponse.success(tradeStockInfo);
    }

    /**
     * 获取股票信息列表
     */
    @PostMapping("getTradeInfoList")
    public HooomeResponse<List<TradeInfoVO>> getTradeInfoList() {
        List<TradeInfoVO> tradeInfoList = tradeService.getTradeInfoList();
        log.info("getTradeInfoList:{}", tradeInfoList);
        return HooomeResponse.success(tradeInfoList);
    }
}
