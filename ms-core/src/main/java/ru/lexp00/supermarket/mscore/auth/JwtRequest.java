package ru.lexp00.supermarket.mscore.auth;

import lombok.Data;

@Data
public class JwtRequest {
    private String username;
    private String password;
}
