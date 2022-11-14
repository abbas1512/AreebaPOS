package com.areeba.POS.controller;

import com.areeba.POS.common.RestCommonResponse;
import com.areeba.POS.dto.CategoryDTO;
import com.areeba.POS.entity.Category;
import com.areeba.POS.services.CategoryService;
import com.areeba.POS.services.Impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/category"})
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
public class CategoryController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private final CategoryService categoryService;
    @Autowired
    private final CategoryServiceImpl categoryServiceImpl;

    public CategoryController(AuthenticationManager authenticationManager, CategoryService categoryService, CategoryServiceImpl categoryServiceImpl) {
        this.authenticationManager = authenticationManager;
        this.categoryService = categoryService;
        this.categoryServiceImpl = categoryServiceImpl;
    }

    @GetMapping
    public Category getCategory(long Id) {
        return this.categoryService.findById(Id);
    }

    @GetMapping({"/all"})
    public RestCommonResponse getAllCategory() {
        return this.categoryService.getAll();
    }

    @GetMapping({"/name"})
    public Category getCategoryName(String name) {
        return this.categoryService.findByName(name);
    }

    @GetMapping({"/create"})
    public Category createCategory(CategoryDTO categoryDTO) {
        return this.categoryService.createCategory(categoryDTO);
    }

    @PutMapping(value = {"/{id}"}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public RestCommonResponse updateCategory(@PathVariable("Id") long Id, @RequestBody CategoryDTO categoryDTO) {
        return this.categoryService.updateCategory(Id, categoryDTO);
    }

    @DeleteMapping({"/{Id}"})
    public RestCommonResponse deleteCategory(@PathVariable("Id") long Id) {
        return this.categoryService.deleteCategory(Id);
    }

    @PostMapping({"/save"})
    public RestCommonResponse saveCategory(@RequestBody CategoryDTO categoryDTO) {
        return this.categoryService.saveCategory(categoryDTO, categoryDTO.getName());
    }
}
