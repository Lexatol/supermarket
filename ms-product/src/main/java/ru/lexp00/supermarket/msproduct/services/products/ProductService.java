package ru.lexp00.supermarket.msproduct.services.products;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.lexp00.supermarket.mscore.exeptions.MessageError;
import ru.lexp00.supermarket.msproduct.dto.products.ProductDto;
import ru.lexp00.supermarket.msproduct.repositories.products.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<ProductDto> findAll() {
        return productRepository.findAll().stream().map(ProductDto::new).collect(Collectors.toList());
    }

    public ProductDto findById(Long id) {
        return productRepository.findById(id).map(ProductDto::new).orElseThrow();
    }
}
