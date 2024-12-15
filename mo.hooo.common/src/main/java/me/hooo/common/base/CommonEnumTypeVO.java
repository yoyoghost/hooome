package me.hooo.common.base;

import lombok.Builder;
import lombok.Data;

/**
 * 股票类型
 */
@Builder
@Data
public class CommonEnumTypeVO {
    private int code;
    private String desc;
}
