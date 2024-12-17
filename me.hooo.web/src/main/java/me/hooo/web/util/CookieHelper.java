package me.hooo.web.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class CookieHelper {

    /**
     * 根据名字获取cookie
     *
     * @param request
     * @param cookieName cookie名字
     * @return
     */
    public static Cookie getCookieByName(HttpServletRequest request, String cookieName) {
        return StringUtils.isBlank(cookieName) ? null : readCookieMap(request).get(cookieName);
    }

    /**
     * 根据cookieName获取cookie中的值，如果没有返回null
     *
     * @param request
     * @param cookieName
     * @return
     */
    public static String getCookieValueByName(HttpServletRequest request, String cookieName) {
        Cookie cookie = getCookieByName(request, cookieName);
        return cookie == null ? null : decodeUtf8(cookie.getValue());
    }

    /**
     * 将cookie封装到Map里面
     *
     * @param request
     * @return
     */
    private static Map<String, Cookie> readCookieMap(HttpServletRequest request) {

        Map<String, Cookie> cookieMap = new HashMap<>();
        Cookie[] cookies = request.getCookies();

        if (null != cookies) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
        }

        return cookieMap;
    }

    public static String decodeUtf8(String param) {
        try {
            return StringUtils.isBlank(param) ? null : URLDecoder.decode(param, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            log.warn("decode to utf8 failed : [{}]", param);
            return null;
        }
    }

    /**
     * 向response里面写入cookie,权限为／
     *
     * @param response
     * @param cookieName
     * @param cookieValue
     * @throws IllegalArgumentException 当cookieName为空时会抛此异常
     */
    public static void setCookie2RootPath(HttpServletResponse response, String cookieName, String cookieValue) throws IllegalArgumentException {
        // 将验证码的key存放到cookie里面
        Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setPath("/");
        cookie.setMaxAge(7 * 24 * 3600);
        response.addCookie(cookie);
    }

    /**
     * 向response里面写入cookie,权限为／
     *
     * @param response
     * @param cookieName
     * @param cookieValue
     * @param maxAge
     * @throws IllegalArgumentException 当cookieName为空时会抛此异常
     */
    public static void setCookie2RootPath(HttpServletResponse response, String cookieName, String cookieValue, int maxAge) throws IllegalArgumentException {
        // 将验证码的key存放到cookie里面
        Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    /**
     * 向response里面写入cookie,权限为／
     *
     * @param response
     * @param cookieName
     * @throws IllegalArgumentException 当cookieName为空时会抛此异常
     */
    public static void clearCookie2RootPath(HttpServletResponse response, String cookieName) throws IllegalArgumentException {
        // 将验证码的key存放到cookie里面
        Cookie cookie = new Cookie(cookieName, null);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }
}
