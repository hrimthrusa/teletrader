package com.example.teletrader.dto.request;

import com.example.teletrader.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String userName;
    private Role role;
}
