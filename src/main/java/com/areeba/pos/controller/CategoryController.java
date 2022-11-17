package com.areeba.pos.controller;

import com.areeba.pos.common.RestCommonResponse;
import com.areeba.pos.dto.CategoryDTO;
import com.areeba.pos.entity.Category;
import com.areeba.pos.services.CategoryService;
import com.areeba.pos.services.Impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/category"})
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

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

    @PostMapping({"/create"})
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
