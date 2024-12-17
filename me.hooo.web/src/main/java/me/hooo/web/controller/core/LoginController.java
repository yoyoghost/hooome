package me.hooo.web.controller.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
import me.hooo.common.HooomeResponse;
import me.hooo.common.base.TokenBO;
import me.hooo.common.constant.AuthConstant;
import me.hooo.dao.core.model.User;
import me.hooo.service.core.IUserService;
import me.hooo.web.util.CookieHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private IUserService userService;

    @PostMapping
    public HooomeResponse<Boolean> login(@RequestBody User user,
                                         HttpServletRequest request, HttpServletResponse response) {

        TokenBO token = userService.login(user.getUsername(), user.getPassword());

        CookieHelper.setCookie2RootPath(response, AuthConstant.ACCESS_TOKEN, token.getAccessToken());
        CookieHelper.setCookie2RootPath(response, AuthConstant.TGC, token.getRefreshToken());

        return HooomeResponse.success(Boolean.TRUE);
    }
}