package com.example.teletrader.enums;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
    ADMIN("ADMIN"),
    USER("USER");
    private final String name;

    Role(String role) {
        this.name = role;
    }

    public String getName() {
        return name;
    }
}