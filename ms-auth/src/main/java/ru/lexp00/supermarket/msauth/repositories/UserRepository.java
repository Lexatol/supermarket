package ru.lexp00.supermarket.msauth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.lexp00.supermarket.msauth.entities.users.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}