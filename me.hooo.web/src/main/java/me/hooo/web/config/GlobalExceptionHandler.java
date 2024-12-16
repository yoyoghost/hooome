package me.hooo.web.config;

import lombok.extern.slf4j.Slf4j;
import me.hooo.common.HooomeResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public HooomeResponse<Object> handleException(Exception e) {
        log.error("", e);
        return HooomeResponse.failure(e.getMessage());
    }
}