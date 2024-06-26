package com.example.redis;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class LoginController {

    //session 연습

    HashMap<String,String> sessionMap = new HashMap<>();


    @GetMapping("/login")
    public String login(HttpSession session,String name){
        sessionMap.put(session.getId(),name);
        return "saved";

    }

    @GetMapping("/myname")
    public String myName(HttpSession session){
       String myName  = sessionMap.get(session.getId());
        return myName;
    }


}
