package com.example.redis.controller;


import com.example.redis.dto.UserProfile;
import com.example.redis.service.UserServce;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ApiController {

    private final UserServce userServce;

    @GetMapping("users/{userId}/profile")
    public UserProfile getUserProfile(@PathVariable(value = "userId")String userId){
        return userServce.getUserProfile(userId);
    }
}
