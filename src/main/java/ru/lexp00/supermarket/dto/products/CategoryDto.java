package ru.lexp00.supermarket.dto.products;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.lexp00.supermarket.entities.products.Category;
import ru.lexp00.supermarket.entities.products.Product;

import java.util.List;
import java.util.stream.Collectors;


@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {
    private Long id;
    private String title;
    private List<String> productList;

    public CategoryDto(Category category) {
        this.id = category.getId();
        this.title = category.getTitle();
        this.productList = category.getProductList().stream().map(Product::getTitle).collect(Collectors.toList());
    }
}
