package com.siyama.legends.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/greeting/")
public class GreetingsController {
    @GetMapping("{message}")
    public String getGreeting(@PathVariable("message") String message){
        return message;
    }

    @GetMapping("")
    public String hello(){
        return "Hello user";
    }

}
