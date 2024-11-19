package me.hooo.web.controller.core;


import lombok.extern.slf4j.Slf4j;
import me.hooo.dao.core.model.User;
import me.hooo.service.core.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private IUserService userService;

    @PostMapping
    public User login(@RequestParam String username, @RequestParam String password) {

        return userService.login(username, password);
    }
}