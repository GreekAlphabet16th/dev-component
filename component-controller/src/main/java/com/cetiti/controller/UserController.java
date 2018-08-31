package com.cetiti.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cetiti.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Reference
    private UserService userService;

    @RequestMapping("/listUser")
    public List<Map<String, Object>> listUser() {
        return userService.listUser();
    }
}
