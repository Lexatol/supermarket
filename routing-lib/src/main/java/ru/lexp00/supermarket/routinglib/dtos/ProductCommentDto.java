package ru.lexp00.supermarket.routinglib.dtos;

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
