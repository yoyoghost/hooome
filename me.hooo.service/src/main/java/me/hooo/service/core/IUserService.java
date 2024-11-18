package me.hooo.service.core;

import me.hooo.dao.core.model.User;

public interface IUserService {
    User login(String username, String password);
}
