package ru.lexp00.supermarket.msproduct.controllers.products;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.lexp00.supermarket.mscore.dto.products.ProductDto;
import ru.lexp00.supermarket.msproduct.services.products.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<ProductDto> getAllProduct() {
        return productService.findAll();
    }

    @GetMapping("/ids")
    public List<ProductDto> getAllProductByIds(List<Long> ids) {
        return productService.findAllByIds(ids);
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDto saveOrUpdate(@RequestBody ProductDto productDto) {
        return productService.saveOrUpdate(productDto);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id) {
        productService.deleteById(id);
    }
}
