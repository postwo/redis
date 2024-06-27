package com.example.redis.service;

import com.sun.source.tree.TryTree;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ExteralApiService {


    public String getUserName(String userId) {
    //외부 서비스나 db호출

        try{
            //호출 될때마다 0.5초를 지연 시킨다
            Thread.sleep(500);
        }catch (InterruptedException e){
        }

        System.out.println("name Other Servcie");

        if (userId.equals("A")){
            return "Adam";
        }

        if (userId.equals("B")){
            return "Bob";
        }

        return "";
    }

    //어노테이션을 활용해 cache 설정
    @Cacheable(cacheNames = "userAgeCache",key = "#userId")
    public int getUserAge(String userId) {

        try{
            //호출 될때마다 0.5초를 지연 시킨다
            Thread.sleep(500);
        }catch (InterruptedException e){
        }

        System.out.println("age Other Servcie");

        if (userId.equals("A")){
            return 28;
        }

        if (userId.equals("B")){
            return 32;
        }

        return 0;
    }

}
