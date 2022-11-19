package com.example.teletrader.security.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
    @NotBlank(message = "Email is mandatory.")
    private String email;
    @NotBlank(message = "Password is mandatory.")
    private String password;
}
