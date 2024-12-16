package me.hooo.service.trade.impl;

import cn.hutool.core.bean.BeanUtil;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import me.hooo.common.constant.StatusEnum;
import me.hooo.common.exception.ServiceException;
import me.hooo.common.trade.TradeConst;
import me.hooo.common.trade.vo.StockStatusVO;
import me.hooo.common.trade.vo.StockTypeVO;
import me.hooo.common.trade.vo.TradeInfoVO;
import me.hooo.common.trade.vo.TradeStockInfoVO;
import me.hooo.dao.trade.model.TradeInfoDO;
import me.hooo.dao.trade.model.TradeStockInfoDO;
import me.hooo.manage.trade.ITradeManager;
import me.hooo.service.trade.ITradeService;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

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
        tradeStockInfoVO.setStockStatus(tradeStockInfoDO.getStockStatus());
        return tradeStockInfoVO;
    }

    @Override
    public List<TradeStockInfoVO> getStockInfoList() {
        List<TradeStockInfoDO> stockInfoList = tradeManager.getStockInfoList(null);
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

    @Override
    public List<StockStatusVO> getStockStatus() {
        TradeConst.StockStatusEnum[] values = TradeConst.StockStatusEnum.values();
        List<StockStatusVO> list = Lists.newArrayList();
        for (TradeConst.StockStatusEnum value : values) {
            list.add(StockStatusVO.builder().code(value.getCode()).desc(value.getDesc()).build());
        }
        log.info("getStockStatus:{}", list);
        return list;
    }

    @Override
    public TradeStockInfoVO editStockInfo(TradeStockInfoVO tradeStockInfoVO) {
        // 新增 TradeStockInfo 到数据库
        log.info("editStockInfo:{}", tradeStockInfoVO);
        // 查询一下
        TradeStockInfoDO tradeStockInfoDO = tradeManager.selectStockInfoById(tradeStockInfoVO.getId());
        if (tradeStockInfoDO == null) {
            throw new ServiceException(StatusEnum.DATA_NOT_EXIST, "股票信息不存在");
        }
        // 赋值
        TradeStockInfoDO tradeStockInfoDOUpdate = BeanUtil.copyProperties(tradeStockInfoVO, TradeStockInfoDO.class);
        // 更新
        tradeManager.updateStockInfo(tradeStockInfoDOUpdate);
        // 重新获取赋值
        tradeStockInfoDO = tradeManager.selectStockInfoById(tradeStockInfoVO.getId());
        BeanUtils.copyProperties(tradeStockInfoDO, tradeStockInfoVO);
        return tradeStockInfoVO;
    }

    @Override
    public TradeStockInfoVO delStockInfo(TradeStockInfoVO tradeStockInfoVO) {
        // 新增 TradeStockInfo 到数据库
        log.info("delStockInfo:{}", tradeStockInfoVO);
        // 查询一下
        TradeStockInfoDO tradeStockInfoDO = tradeManager.selectStockInfoById(tradeStockInfoVO.getId());
        if (tradeStockInfoDO == null) {
            throw new ServiceException(StatusEnum.DATA_NOT_EXIST, "股票信息不存在");
        }
        // 更新
        tradeManager.deleteStockInfoById(tradeStockInfoVO.getId());
        return tradeStockInfoVO;
    }

    @Override
    public List<TradeStockInfoVO> getDCStockInfoList() {
        List<Integer> dcStockTypeList = TradeConst.StockTypeEnum.getDCStockType();
        List<TradeStockInfoDO> stockInfoList = tradeManager.getStockInfoList(dcStockTypeList);
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

    @Override
    public List<TradeInfoVO> getInProgressTradeInfoList() {
        // 获取进行中的交易信息列表
        List<TradeInfoDO> tradeInfoList = tradeManager.getTradeInfoList(TradeConst.TradeTypeEnum.BUY.getCode(),
                Lists.newArrayList(TradeConst.TradeStatusEnum.BUY_IN.getCode(), TradeConst.TradeStatusEnum.PART_SELL.getCode()));
        if (CollectionUtils.isEmpty(tradeInfoList)) {
            return Lists.newArrayList();
        }

        List<TradeInfoVO> list = Lists.newArrayList();
        for (TradeInfoDO tradeInfoDO : tradeInfoList) {
            TradeInfoVO vo = new TradeInfoVO();
            // 默认可以编辑
            vo.setIsCanEdit(NumberUtils.INTEGER_ONE);
            BeanUtils.copyProperties(tradeInfoDO, vo);
            // 如果不是全部卖出，则不可以编辑
            if(!Objects.equals(tradeInfoDO.getTradeNumber(), tradeInfoDO.getTradeRemainingNumber())) {
                vo.setIsCanEdit(NumberUtils.INTEGER_ZERO);
            }
            list.add(vo);
        }
        return list;
    }

    @Override
    public TradeInfoVO addTradeInfo(TradeInfoVO tradeInfoVO) {
        log.info("addTradeInfo:{}", tradeInfoVO);

        // 新增 TradeStockInfo 到数据库
        Integer tradeType = tradeInfoVO.getTradeType();
        // 买入时，默认设置为买入中
        if (tradeType.intValue() == TradeConst.TradeTypeEnum.BUY.getCode()) {
            tradeInfoVO.setTradeStatus(TradeConst.TradeStatusEnum.BUY_IN.getCode());
            tradeInfoVO.setTradeRemainingNumber(tradeInfoVO.getTradeNumber());
        } else {
            tradeInfoVO.setTradeStatus(TradeConst.TradeStatusEnum.ALL_SELL.getCode());
            tradeInfoVO.setTradeRemainingNumber(NumberUtils.INTEGER_ZERO);
        }

        TradeInfoDO tradeInfoDO = new TradeInfoDO();
        BeanUtils.copyProperties(tradeInfoVO, tradeInfoDO);
        tradeManager.addTradeInfo(tradeInfoDO);
        tradeInfoVO.setId(tradeInfoDO.getId());
        tradeInfoVO.setIsCanEdit(NumberUtils.INTEGER_ONE);// 可编辑
        return tradeInfoVO;
    }

    @Override
    public TradeInfoVO editTradeInfo(TradeInfoVO tradeInfoVO) {
        Long id = tradeInfoVO.getId();
        TradeInfoDO tradeInfoDO = tradeManager.selectTradeInfoById(id);
        // 编辑的时候首先判断是否存在
        if(null == tradeInfoDO) {
            throw new ServiceException(StatusEnum.DATA_NOT_EXIST, "交易信息不存在");
        }
        // 在判断买入数量和剩余数量是否一致，如果不一致则不允许编辑
        if(!Objects.equals(tradeInfoDO.getTradeNumber(), tradeInfoDO.getTradeRemainingNumber())) {
            throw new ServiceException(StatusEnum.SERVICE_ERROR, "交易信息不允许编辑");
        }

        TradeInfoDO updateTradeInfoDO = BeanUtil.copyProperties(tradeInfoVO, TradeInfoDO.class);
        updateTradeInfoDO.setTradeRemainingNumber(tradeInfoVO.getTradeNumber());
        tradeManager.updateTradeInfo(updateTradeInfoDO);

        tradeInfoVO.setTradeRemainingNumber(tradeInfoVO.getTradeNumber());
        tradeInfoVO.setIsCanEdit(NumberUtils.INTEGER_ONE);// 可编辑
        return tradeInfoVO;
    }

    @Override
    public TradeInfoVO delTradeInfo(TradeInfoVO tradeInfoVO) {
        Long id = tradeInfoVO.getId();
        TradeInfoDO tradeInfoDO = tradeManager.selectTradeInfoById(id);
        // 编辑的时候首先判断是否存在
        if(null == tradeInfoDO) {
            throw new ServiceException(StatusEnum.DATA_NOT_EXIST, "交易信息不存在");
        }
        // 在判断买入数量和剩余数量是否一致，如果不一致则不允许编辑
        if(!Objects.equals(tradeInfoDO.getTradeNumber(), tradeInfoDO.getTradeRemainingNumber())) {
            throw new ServiceException(StatusEnum.SERVICE_ERROR, "交易信息不允许编辑");
        }
        // 更新deleted字段
        tradeManager.deleteTradeInfoById(id);
        return tradeInfoVO;
    }
}
