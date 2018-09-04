package com.cetiti;

import com.cetiti.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private ValueOperations<String, Object> valueOperations;

    @Test
    public void redisTemplateTest() {
        User user = new User();
        user.setUserId(1L);
        user.setUserName("zhouliyu");
        user.setPassWord("123.com");
        //valueOperations.set("test1", user);
        System.out.println(valueOperations.get("test1"));
    }
}
