package ru.lexp00.supermarket.msorder.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.lexp00.supermarket.mscore.dto.products.ProductDto;

import java.util.List;

@FeignClient("ms-product")
public interface ProductClient {

    @GetMapping("api/v1/products")
    List<ProductDto> getAllProduct();

    @GetMapping("api/v1/products/ids")
    List<ProductDto> getAllProductByIds(@RequestParam List<Long> ids);

    @GetMapping("api/v1/products/{id}")
    ProductDto getProductById(@PathVariable Long id);

    @PostMapping("api/v1/products")
    @ResponseStatus(HttpStatus.CREATED)
    ProductDto saveOrUpdate(@RequestBody ProductDto productDto);

    @DeleteMapping("api/v1/products/{id}")
    void deleteProductById(@PathVariable Long id);

}
