package com.project.employee_records.service;

import com.project.employee_records.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CategoryService {
    Optional<Category> getCategory(Integer idCategory);
    Page<Category> getCategories(Pageable pageable);
    Category setCategory(Category category);
    void deleteCategory(Integer idCategory);
}
