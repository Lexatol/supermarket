package ru.lexp00.supermarket.controllers.products;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.lexp00.supermarket.dto.products.ProductDto;
import ru.lexp00.supermarket.entities.products.Product;
import ru.lexp00.supermarket.services.products.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<ProductDto> getAll() {
        return productService.findAll();
    }


}
