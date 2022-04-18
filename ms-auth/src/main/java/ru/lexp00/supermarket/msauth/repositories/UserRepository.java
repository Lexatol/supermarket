package ru.lexp00.supermarket.msauth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.lexp00.supermarket.mscore.entities.users.User;

public interface UserRepository extends JpaRepository<User, Long> {
}