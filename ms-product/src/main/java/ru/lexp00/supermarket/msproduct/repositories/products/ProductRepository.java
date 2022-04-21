package ru.lexp00.supermarket.msproduct.repositories.products;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.lexp00.supermarket.msproduct.entities.products.Product;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByIdIn(List<Long> ids);
}
