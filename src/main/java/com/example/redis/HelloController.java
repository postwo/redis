package com.example.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

        @GetMapping("hello")
        public String hello(){
            return "hello world";
        }

        @GetMapping("setFruit")
        public String setfruit(String name){
        ValueOperations<String,String> ops=stringRedisTemplate.opsForValue();
        ops.set("fruit",name);
        return "saved";
        }

        @GetMapping("getFruit")
        public String getfruit(){
            ValueOperations<String,String> ops=stringRedisTemplate.opsForValue();
            String fruitname = ops.get("fruit"); //키 값에 있는 값을 갖고 온다
            return fruitname;
        }
}
