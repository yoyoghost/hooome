package me.hooo.service.core;


import lombok.extern.slf4j.Slf4j;
import me.hooo.dao.core.model.User;
import me.hooo.service.HooomeTestApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest(classes = HooomeTestApplication.class)
public class UserServiceTest {

    @Autowired
    IUserService userService;

    @Test
    void testLogin() {
        // 创建模拟数据
        User mockUser = new User();
        mockUser.setUsername("default");
        mockUser.setPassword("123");

        User login = userService.login(mockUser.getUsername(), mockUser.getPassword());
        log.info("login: {}", login);
    }
}
