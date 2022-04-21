package ru.lexp00.supermarket.mscore.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.lexp00.supermarket.mscore.dto.products.CategoryDto;

import java.util.List;

@FeignClient("ms-product")
public interface CategoryClient {

    @GetMapping("/api/v1/categories")
    List<CategoryDto> getAll();

    @GetMapping("api/v1/categories/{id}")
    CategoryDto getCategoryById(@PathVariable Long id);

    @PostMapping("api/v1/categories")
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryDto saveOrUpdateCategory(@RequestBody CategoryDto categoryDto);

    @DeleteMapping("api/v1/categories/{id}")
    public void deleteCategory(@PathVariable Long id);
}
