package ru.lexp00.supermarket.repositories.products;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.lexp00.supermarket.entities.products.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
