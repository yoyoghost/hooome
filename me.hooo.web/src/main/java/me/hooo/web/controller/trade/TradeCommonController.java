package me.hooo.web.controller.trade;

import lombok.extern.slf4j.Slf4j;
import me.hooo.common.HooomeResponse;
import me.hooo.common.base.CommonEnumTypeVO;
import me.hooo.service.trade.ITradeCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 通用接口
 */
@Slf4j
@RestController
@RequestMapping("trade/common")
public class TradeCommonController {

    @Autowired
    ITradeCommonService tradeCommonService;

    /**
     * 获取股票类型信息
     */
    @PostMapping("getTradeType")
    public HooomeResponse<List<CommonEnumTypeVO>> getTradeType() {
        List<CommonEnumTypeVO> tradeTypeVOList = tradeCommonService.getEnumVOList("TradeTypeEnum");
        return HooomeResponse.success(tradeTypeVOList);
    }
}