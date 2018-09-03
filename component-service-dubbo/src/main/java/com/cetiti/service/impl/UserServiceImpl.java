package com.cetiti.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cetiti.service.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(timeout = 5000)
public class UserServiceImpl implements UserService {
    @Override
    public List<Map<String, Object>> listUser() {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> user = new HashMap<>();
        user.put("name", "zhouliyu");
        user.put("age", 18);
        list.add(user);
        return list;
    }
}
