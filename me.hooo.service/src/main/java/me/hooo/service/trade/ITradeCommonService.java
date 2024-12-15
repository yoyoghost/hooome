package me.hooo.service.trade;

import me.hooo.common.base.CommonEnumTypeVO;

import java.util.List;

public interface ITradeCommonService {
    List<CommonEnumTypeVO> getEnumVOList(String enumName);
}
