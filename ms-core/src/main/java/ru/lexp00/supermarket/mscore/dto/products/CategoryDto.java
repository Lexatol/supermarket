package ru.lexp00.supermarket.mscore.dto.products;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {
    private Long id;
    private String title;
    private List<String> productList;
}
