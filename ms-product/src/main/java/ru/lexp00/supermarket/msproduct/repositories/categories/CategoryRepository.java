package ru.lexp00.supermarket.msproduct.repositories.categories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.lexp00.supermarket.msproduct.entities.categories.Category;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByTitle(String title);
}