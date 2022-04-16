package ru.lexp00.supermarket.repositories.users;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.lexp00.supermarket.entities.users.CashBack;

public interface CashBackRepository extends JpaRepository<CashBack, Long> {
}