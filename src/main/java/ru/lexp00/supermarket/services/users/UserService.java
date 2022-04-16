package ru.lexp00.supermarket.services.users;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.lexp00.supermarket.dto.users.UserDto;
import ru.lexp00.supermarket.repositories.users.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(UserDto::new).collect(Collectors.toList());
    }

    public UserDto findById(Long id) {
        return userRepository.findById(id).map(UserDto::new).orElseThrow();

    }
}
