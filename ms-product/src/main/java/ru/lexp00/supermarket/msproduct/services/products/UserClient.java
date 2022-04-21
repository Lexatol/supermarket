package ru.lexp00.supermarket.msproduct.services.products;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.lexp00.supermarket.mscore.dto.users.UserDto;

@FeignClient ("ms-auth")
public interface UserClient {

    @GetMapping("/api/v1/users/{id}")
    UserDto getById(@PathVariable Long id);
}
