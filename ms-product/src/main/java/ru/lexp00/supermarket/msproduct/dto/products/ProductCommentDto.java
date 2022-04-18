package ru.lexp00.supermarket.msproduct.dto.products;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.lexp00.supermarket.msproduct.entities.products.ProductComment;

@Getter
@Setter
@NoArgsConstructor
public class ProductCommentDto {
    private Long id;
    private String description;

    public ProductCommentDto(ProductComment comment) {
        this.id = comment.getComment_id();
        this.description = comment.getDescription();
    }
}
