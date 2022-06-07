package ru.lexp00.supermarket.msproduct.services.products;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.lexp00.supermarket.mscore.exeptions.ResourceNotFoundException;
import ru.lexp00.supermarket.msproduct.entities.categories.Category;
import ru.lexp00.supermarket.msproduct.entities.products.Product;
import ru.lexp00.supermarket.msproduct.entities.products.ProductComment;
import ru.lexp00.supermarket.msproduct.repositories.products.ProductRepository;
import ru.lexp00.supermarket.msproduct.services.UserClient;
import ru.lexp00.supermarket.msproduct.services.categories.CategoryService;
import ru.lexp00.supermarket.routinglib.dtos.ProductCommentDto;
import ru.lexp00.supermarket.routinglib.dtos.ProductDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final UserClient userClient;

    public List<ProductDto> findAll() {
        return productRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public List<ProductDto> findAllByIds(List<Long> ids) {
        return productRepository.findByIdIn(ids).stream().map(this::toDto).collect(Collectors.toList());
    }

    public ProductDto findById(Long id) {
        return productRepository.findById(id).map(this::toDto).orElseThrow(()-> new ResourceNotFoundException("Product with " + id + " is not found"));
    }

    public ProductDto saveOrUpdate(ProductDto productDto) {
        return toDto(productRepository.save(toEntity(productDto)));
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    private ProductDto toDto(Product product) {

        ProductDto productDto = ProductDto.builder()
                .id(product.getId())
                .title(product.getTitle())
                .price(product.getPrice())
                .category(product.getCategoryList().stream().map(Category::getTitle).collect(Collectors.toList()))
                .comment(product.getProductCommentList().stream().map(this::toDtoComment).collect(Collectors.toList()))
                .build();
        return productDto;
    }

    private Product toEntity(ProductDto productDto) {
        Product product = Product.builder()
                .id(productDto.getId())
                .title(productDto.getTitle())
                .price(productDto.getPrice())
                .description(productDto.getDescription())
                .categoryList(productDto.getCategory().stream().map(this::findCategory).collect(Collectors.toList()))
                .build();
        return product;
    }

    private ProductCommentDto toDtoComment(ProductComment productComment) {
        String username = userClient.getById(productComment.getUser_id()).getUsername();

        ProductCommentDto commentDto = ProductCommentDto.builder()
                .id(productComment.getComment_id())
                .username(username)
                .description(productComment.getDescription())
                .build();
        return commentDto;
    }

    private Category findCategory(String title) {
        return categoryService.findByTitle(title);
    }


}
