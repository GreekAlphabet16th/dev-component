package com.cetiti.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cetiti.cache.ValueOptions;
import com.cetiti.domain.User;
import com.cetiti.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Reference(check = false)
    private UserService userService;
    @Reference(check = false)
    private ValueOptions valueOptions;

    /**
     * myBatis测试
     */
    @RequestMapping("/listUser")
    public List<User> listUser() {
        return userService.listUser();
    }

    /**
     * Redis测试
     */
    @RequestMapping("/getValue/{key}")
    public Object getValue(@PathVariable String key) {
        return valueOptions.getValue(key);
    }
}
