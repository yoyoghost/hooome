package me.hooo.manage.core;

import me.hooo.dao.core.model.User;

public interface IUserManage {
    User findUserByUsernameAndPassword(String username, String password);
}
