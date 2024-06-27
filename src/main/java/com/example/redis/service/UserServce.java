package com.example.redis.service;

import com.example.redis.dto.UserProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class UserServce {

    private final ExteralApiService exteralApiService;
    private final StringRedisTemplate RedisTemplate;

    public UserProfile getUserProfile(String userId) {
        String userName= null;

        //getusername을 호출하기 전에 캐싱을 먼저 체크
        ValueOperations<String,String> ops = RedisTemplate.opsForValue();
        String cachedName = ops.get("nameKey:"+userId);
        if (cachedName != null){
            System.out.println("test");
        userName = cachedName;
        }else{
            System.out.println("재접속");
            userName= exteralApiService.getUserName(userId);
            ops.set("nameKey:"+userId, userName, 5, TimeUnit.SECONDS);
        }


//        String UserName = exteralApiService.getUserName(userId);
        int UserAge = exteralApiService.getUserAge(userId);

        return new UserProfile(userName,UserAge);
    }
}
