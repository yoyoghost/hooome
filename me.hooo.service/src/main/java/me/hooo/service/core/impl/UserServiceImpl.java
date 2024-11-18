package me.hooo.service.core.impl;

import me.hooo.dao.core.model.User;
import me.hooo.manage.core.IUserManage;
import me.hooo.service.core.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserManage userManage;

    public User login(String username, String password) {
        return userManage.findUserByUsernameAndPassword(username, password);
    }
}
