package com.example.punkty;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public static String hello(){
        return "hello " + LocalDateTime.now();
    }
}
