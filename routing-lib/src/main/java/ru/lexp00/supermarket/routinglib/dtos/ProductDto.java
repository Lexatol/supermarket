package ru.lexp00.supermarket.routinglib.dtos;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long id;
    private String title;
    private int price;
    private List<String> category;
    private String description;
    private List<ProductCommentDto> comment;
}
