package ru.lexp00.supermarket.repositories.users;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.lexp00.supermarket.entities.users.User;

public interface UserRepository extends JpaRepository<User, Long> {
}