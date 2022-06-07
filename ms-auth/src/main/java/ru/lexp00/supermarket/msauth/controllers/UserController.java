package ru.lexp00.supermarket.msauth.controllers;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
import ru.lexp00.supermarket.msauth.services.UserService;
import ru.lexp00.supermarket.routinglib.dtos.UserDto;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping ("/{id}")
    public UserDto getById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping ("/username")
    public UserDto getByUsername(@RequestParam String username) {
        return userService.findByUsername(username);
    }
}
