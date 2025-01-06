package com.project.employee_records.service;

import com.project.employee_records.model.Category;
import com.project.employee_records.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    @Override
    public Optional<Category> getCategory(Integer idCategory) {
        return categoryRepository.findById(idCategory);
    }

    @Override
    public Page<Category> getCategories(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Category setCategory(Category category) {
        categoryRepository.save(category);
        return category;
    }

    @Override
    public void deleteCategory(Integer idCategory) {
        categoryRepository.deleteById(idCategory);
    }
}
