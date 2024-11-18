package me.hooo.manage.core.impl;

import me.hooo.dao.core.mapper.UserMapper;
import me.hooo.dao.core.model.User;
import me.hooo.manage.core.IUserManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserManageImpl implements IUserManage {

    @Autowired
    UserMapper userMapper;

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        return userMapper.findUserByUsernameAndPassword(username, password);
    }
}
