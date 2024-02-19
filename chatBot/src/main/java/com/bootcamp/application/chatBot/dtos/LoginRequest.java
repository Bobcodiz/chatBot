package com.bootcamp.application.chatBot.dtos;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
