package com.cetiti.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cetiti.dao.user.UserDao;
import com.cetiti.domain.User;
import com.cetiti.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(timeout = 5000)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> listUser() {
        return userDao.listUser();
    }
}
