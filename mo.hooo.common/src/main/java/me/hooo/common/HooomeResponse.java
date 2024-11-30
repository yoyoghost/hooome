package me.hooo.common;

import lombok.Data;

@Data
public class HooomeResponse<T> {
    private int code;
    private String message;
    private T data;

    public HooomeResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // 根据不同的情况，可以添加一些快捷构造方法
    public static <T> HooomeResponse<T> success(T data) {
        return new HooomeResponse<>(200, "Success", data);
    }

    public static <T> HooomeResponse<T> failure(String message) {
        return new HooomeResponse<>(500, message, null);
    }
}