package me.hooo.web.controller.trade;

import lombok.extern.slf4j.Slf4j;
import me.hooo.common.HooomeResponse;
import me.hooo.common.trade.vo.TradeInfoVO;
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

    @PostMapping("addTradeInfo")
    public HooomeResponse<TradeInfoVO> addTradeInfo(@RequestBody TradeInfoVO tradeInfoVO) {
        log.info("addTradeInfo:{}", tradeInfoVO);
        TradeInfoVO tradeInfo = tradeService.addTradeInfo(tradeInfoVO);
        return HooomeResponse.success(tradeInfo);
    }

    @PostMapping("editTradeInfo")
    public HooomeResponse<TradeInfoVO> editTradeInfo(@RequestBody TradeInfoVO tradeInfoVO) {
        log.info("editTradeInfo:{}", tradeInfoVO);
        TradeInfoVO tradeInfo = tradeService.editTradeInfo(tradeInfoVO);
        return HooomeResponse.success(tradeInfo);
    }

    @PostMapping("delTradeInfo")
    public HooomeResponse<TradeInfoVO> delTradeInfo(@RequestBody TradeInfoVO tradeInfoVO) {
        log.info("delTradeInfo:{}", tradeInfoVO);
        TradeInfoVO tradeInfo = tradeService.delTradeInfo(tradeInfoVO);
        return HooomeResponse.success(tradeInfo);
    }

    /**
     * 获取股票信息列表
     */
    @PostMapping("getInProgressTradeInfoList")
    public HooomeResponse<List<TradeInfoVO>> getInProgressTradeInfoList() {
        List<TradeInfoVO> tradeInfoList = tradeService.getInProgressTradeInfoList();
        log.info("getInProgressTradeInfoList:{}", tradeInfoList);
        return HooomeResponse.success(tradeInfoList);
    }
}
