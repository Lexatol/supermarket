package ru.lexp00.supermarket.msauth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.lexp00.supermarket.mscore.entities.users.CashBack;

public interface CashBackRepository extends JpaRepository<CashBack, Long> {
}