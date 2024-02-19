package com.bootcamp.application.chatBot.controllers;

import com.bootcamp.application.chatBot.dtos.RegistrationRequest;
import com.bootcamp.application.chatBot.services.AuthenticationResponse;
import com.bootcamp.application.chatBot.services.UserRegDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class AuthenticationController {
    private final UserRegDetailsService register;
    @PostMapping("register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegistrationRequest req){
        return ResponseEntity.ok(register.userRegister(req));
    }
}
