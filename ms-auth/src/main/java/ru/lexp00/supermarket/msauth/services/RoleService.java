package ru.lexp00.supermarket.msauth.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.lexp00.supermarket.msauth.entities.Role;
import ru.lexp00.supermarket.msauth.repositories.RoleRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role findByName(String username) {
        return roleRepository.findRoleByName(username);
    }
}
