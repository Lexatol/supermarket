package ru.lexp00.supermarket.msproduct.repositories.products;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.lexp00.supermarket.msproduct.entities.products.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}