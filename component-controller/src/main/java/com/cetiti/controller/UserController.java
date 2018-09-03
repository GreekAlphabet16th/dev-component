package com.cetiti.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cetiti.domain.User;
import com.cetiti.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Reference
    private UserService userService;

    @RequestMapping("/listUser")
    public List<User> listUser() {
        return userService.listUser();
    }
}
