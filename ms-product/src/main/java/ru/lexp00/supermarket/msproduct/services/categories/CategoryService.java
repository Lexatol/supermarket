package ru.lexp00.supermarket.msproduct.services.categories;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.lexp00.supermarket.mscore.exeptions.ResourceNotFoundException;
import ru.lexp00.supermarket.msproduct.entities.categories.Category;
import ru.lexp00.supermarket.msproduct.repositories.categories.CategoryRepository;
import ru.lexp00.supermarket.routinglib.dtos.CategoryDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public Category findByTitle(String title) {
        return categoryRepository.findByTitle(title)
                .orElseThrow(()-> new ResourceNotFoundException("Category with title ' " + title + "' is not found"));
    }

    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public CategoryDto findById(Long id) {
        return categoryRepository.findById(id)
                .map(this::toDto)
                .orElseThrow(()-> new ResourceNotFoundException("Category with " + id + " is not found"));
    }

    public CategoryDto saveOrUpdate(CategoryDto categoryDto) {
        return toDto(categoryRepository.save(toEntity(categoryDto)));
    }

    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }

    private CategoryDto toDto(Category category) {
        return modelMapper.map(category, CategoryDto.class);
    }

    private Category toEntity(CategoryDto categoryDto) {
        return modelMapper.map(categoryDto, Category.class);
    }


}
