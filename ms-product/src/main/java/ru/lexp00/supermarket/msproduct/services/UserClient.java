package ru.lexp00.supermarket.msproduct.services;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.lexp00.supermarket.mscore.auth.JwtRequest;
import ru.lexp00.supermarket.routinglib.dtos.UserDto;

@FeignClient("ms-auth")
public interface UserClient {

    @PostMapping("/login")
    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authRequest);

    @GetMapping("/api/v1/users/{id}")
    UserDto getById(@PathVariable Long id);

    @GetMapping("/api/v1/users/username")
    UserDto getByUsername(@RequestParam String username);
}
