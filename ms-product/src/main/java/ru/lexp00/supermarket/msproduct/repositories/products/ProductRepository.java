package ru.lexp00.supermarket.msproduct.repositories.products;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.lexp00.supermarket.msproduct.entities.products.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {
}
