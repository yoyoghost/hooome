package me.hooo.common.exception;

import lombok.Getter;
import me.hooo.common.constant.StatusEnum;

public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = 3610237750663871675L;

    @Getter
    private int code;

    public ServiceException(int code, String message) {
        super(message);
        this.code = code;
    }

    public ServiceException(StatusEnum status) {
        this(status.code(), status.cnMessage());
    }

    public ServiceException(StatusEnum status, String msg) {
        this(status.code(), msg);
    }

}
