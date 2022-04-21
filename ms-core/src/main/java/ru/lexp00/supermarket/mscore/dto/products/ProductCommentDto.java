package ru.lexp00.supermarket.mscore.dto.products;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductCommentDto {
    private Long id;
    private String username;
    private String description;
}
