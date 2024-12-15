package me.hooo.service.trade.impl;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import me.hooo.common.base.CommonEnumTypeVO;
import me.hooo.common.constant.StatusEnum;
import me.hooo.common.exception.ServiceException;
import me.hooo.service.trade.ITradeCommonService;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;

@Slf4j
@Service
public class TradeCommonServiceImpl implements ITradeCommonService {

    @Override
    public List<CommonEnumTypeVO> getEnumVOList(String enumName) {
        List<CommonEnumTypeVO> commonEnumTypeVOList = Lists.newArrayList();
        try {
            // 首先获取常量接口类
            String interfaceName = "me.hooo.common.trade.TradeConst";
            Class<?> interfaceClass = Class.forName(interfaceName);
            Class<?>[] classes = interfaceClass.getDeclaredClasses();
            for (Class<?> nestedClass : classes) {
                if (nestedClass.isEnum()) {
                    String className = nestedClass.getName();
                    // 截取内部类名称，去掉前面的包名和内部类标识符
                    className = className.substring(className.lastIndexOf("$") + 1);
                    if (className.equals(enumName)) {
                        Object[] enumConstants = nestedClass.getEnumConstants();
                        for (Object enumConstant : enumConstants) {
                            // 获取枚举实例的所有字段
                            Field[] fields = nestedClass.getDeclaredFields();
                            CommonEnumTypeVO.CommonEnumTypeVOBuilder enumTypeVOBuilder = CommonEnumTypeVO.builder();
                            for (Field field : fields) {
                                // 设置字段为可访问的
                                field.setAccessible(true);
                                // 获取字段的值
                                Object value = field.get(enumConstant);
                                if (field.getName().equals("code")) {
                                    enumTypeVOBuilder.code((Integer) value);
                                } else if (field.getName().equals("desc")) {
                                    enumTypeVOBuilder.desc((String) value);
                                }
                            }
                            commonEnumTypeVOList.add(enumTypeVOBuilder.build());
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException e) {
            throw new ServiceException(StatusEnum.DATA_NOT_EXIST, "枚举类不存在");
        }
        return commonEnumTypeVOList;
    }
}
