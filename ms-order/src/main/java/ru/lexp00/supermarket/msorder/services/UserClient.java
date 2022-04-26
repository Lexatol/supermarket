package ru.lexp00.supermarket.msorder.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.lexp00.supermarket.mscore.dto.users.UserDto;

@FeignClient ("ms-auth")
public interface UserClient {

    @GetMapping("/api/v1/users/{id}")
    UserDto getById(@PathVariable Long id);

    @GetMapping("/api/v1/users/username")
    UserDto getByUsername(@RequestParam String username);
}
