package me.hooo.common.constant;

import lombok.Getter;

@Getter
public enum StatusEnum {
    SUCCESS(200, "success", "success.", "成功."),

    UNAUTHORIZED(401, "unauthorized", "unauthorized", "用户认证失败"),
    FORBIDDEN(403, "forbidden", "forbidden", "权限不足"),
    SERVICE_ERROR(500, "service_error", "service_error", "服务器错误"),
    CAPTCHA_INVALID(405, "captcha_invalid", "captcha_invalid", "验证码校验失败"),

    DATA_NOT_EXIST(1007, "data_not_exist", "data not exist.", "数据不存在."),
    DATA_EXIST(1008, "data_exist", "data already exist.", "数据已存在."),
    ;

    private int code;
    private String message;
    private String enMessage;
    private String cnMessage;

    StatusEnum(int code, String message, String enMessage, String cnMessage) {
        this.code = code;
        this.message = message;
        this.enMessage = enMessage;
        this.cnMessage = cnMessage;
    }

    public Integer code() {
        return this.code;
    }

    public String cnMessage() {
        return this.cnMessage;
    }
}
