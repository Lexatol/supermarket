package ru.lexp00.supermarket.msauth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.lexp00.supermarket.msauth.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findRoleByName(String name);
}
