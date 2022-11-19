package com.example.teletrader.security.responseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoResponse {
    @NotNull(message = "Id is mandatory.")
    private Long id;
    @NotBlank(message = "Username is mandatory.")
    private String userName;
}
