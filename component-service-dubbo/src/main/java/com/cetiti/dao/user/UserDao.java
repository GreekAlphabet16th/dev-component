package com.cetiti.dao.user;


import com.cetiti.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    List<User> listUser();
}
