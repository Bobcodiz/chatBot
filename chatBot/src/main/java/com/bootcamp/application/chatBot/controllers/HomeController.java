package com.bootcamp.application.chatBot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vi")
public class HomeController {
    @GetMapping("/home")
    public String welcome(){
        return "<p>Welcome home</p>";
    }
}
