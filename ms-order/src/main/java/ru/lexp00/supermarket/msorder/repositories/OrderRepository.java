package ru.lexp00.supermarket.msorder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lexp00.supermarket.msorder.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
