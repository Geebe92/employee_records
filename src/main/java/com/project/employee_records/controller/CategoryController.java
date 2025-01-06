package com.project.employee_records.controller;

import com.project.employee_records.model.Category;
import com.project.employee_records.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/categories/{idCat}")
    public ResponseEntity<Category> getCategory(@PathVariable Integer idCat){
        return ResponseEntity.of(categoryService.getCategory(idCat));
    }

    @GetMapping("/categories")
    public Page<Category> getCategories(Pageable pageable){
        return categoryService.getCategories(pageable);
    }

    @PostMapping("/categories")
    public ResponseEntity<Void> saveCategory(@RequestBody Category category){
        Category createCategory = categoryService.setCategory(category);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{idCat}").buildAndExpand(createCategory.getIdCat()).toUri();
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(location);
        headers.add("Access-Control-Expose-Headers", "*");
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/categories/{idCat}")
    public ResponseEntity<Void> updateCategory(@RequestBody Category category, @PathVariable Integer idCat){
        return categoryService.getCategory(idCat)
                .map(c -> {
                    categoryService.setCategory(category);
                    return new ResponseEntity<Void>(HttpStatus.OK);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/categories/{idCat}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Integer idCat){
        return categoryService.getCategory(idCat)
                .map(c -> {
                    categoryService.deleteCategory(idCat);
                    return new ResponseEntity<Void>(HttpStatus.OK);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
