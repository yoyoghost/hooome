package me.hooo.web.controller.trade;

import lombok.extern.slf4j.Slf4j;
import me.hooo.common.HooomeResponse;
import me.hooo.common.trade.vo.TradeInfoVO;
import me.hooo.service.trade.ITradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("trade/dashboard")
public class TradeDashboardController {

    @Autowired
    ITradeService tradeService;

    /**
     * 获取最低点位的前两条交易信息
     * @return
     */
    @PostMapping("getSmallTradePoint")
    public HooomeResponse<List<TradeInfoVO>> getSmallTradePoint() {
        List<TradeInfoVO> tradeInfoVOList = tradeService.getSmallTradePoint();
        return HooomeResponse.success(tradeInfoVOList);
    }

}
