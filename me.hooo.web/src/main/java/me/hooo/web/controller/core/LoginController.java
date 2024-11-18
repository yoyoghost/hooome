package me.hooo.web.controller.core;


import me.hooo.dao.core.model.User;
import me.hooo.service.core.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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