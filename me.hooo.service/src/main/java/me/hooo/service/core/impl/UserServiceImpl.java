package me.hooo.service.core.impl;

import me.hooo.common.base.TokenBO;
import me.hooo.common.constant.StatusEnum;
import me.hooo.common.exception.ServiceException;
import me.hooo.dao.core.model.User;
import me.hooo.manage.core.IUserManage;
import me.hooo.service.core.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserManage userManage;

    public TokenBO login(String username, String password) {
        User user = userManage.findUserByUsernameAndPassword(username, password);
        if(null == user) {
            throw new ServiceException(StatusEnum.SERVICE_ERROR, "用户名或密码错误");
        }
        return TokenBO.builder().build();
    }
}
