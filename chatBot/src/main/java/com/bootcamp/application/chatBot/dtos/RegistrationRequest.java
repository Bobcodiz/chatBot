package com.bootcamp.application.chatBot.dtos;

import lombok.Data;

@Data
public class RegistrationRequest {
    private String username;
    private String email;
    private String password;
}
