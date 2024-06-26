package com.example.redis.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class UserProfile {

    @JsonProperty //json형태로 똑바로 나오게 하기위해서 사용
    private String name;

    @JsonProperty
    private int age;

}
