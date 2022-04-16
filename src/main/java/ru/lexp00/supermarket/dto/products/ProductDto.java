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
public class ProductDto {
    private Long id;
    private String title;
    private int price;
    private List<String> category;
    private String description;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.price = product.getPrice();
        this.category = product.getCategoryList().stream().map(Category::getTitle).collect(Collectors.toList());
        this.description = product.getDescription();
    }
}
