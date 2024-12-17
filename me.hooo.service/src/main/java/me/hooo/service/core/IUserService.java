package me.hooo.service.core;

import me.hooo.common.base.TokenBO;
import me.hooo.dao.core.model.User;

public interface IUserService {
    TokenBO login(String username, String password);
}
