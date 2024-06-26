package com.example.redis.service;

import com.example.redis.dto.UserProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServce {

    private final ExteralApiService exteralApiService;


    public UserProfile getUserProfile(String userId) {
        String UserName = exteralApiService.getUserName(userId);
        int UserAge = exteralApiService.getUserAge(userId);

        return new UserProfile(UserName,UserAge);
    }
}
