package com.areeba.POS.services.Impl;

import com.areeba.POS.dto.CategoryDTO;
import com.areeba.POS.entity.Category;
import com.areeba.POS.repository.CategoryRepository;
import com.areeba.POS.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CategoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public void createCategory(CategoryDTO categoryDTO) throws Exception {
        Category category = new Category();
        category.setName(categoryDTO.getName());
        categoryRepository.save(category);
    }

    @Override
    public void updateCategory(CategoryDTO categoryDTO, long Id) {
        Category categoryById = categoryRepository.findById(Id);
        categoryById.setName(categoryDTO.getName());
        categoryRepository.save(categoryById);
    }

    @Override
    public void deleteCategory(long Id) {
        categoryRepository.deleteById(Id);
    }

    @Override
    public Category findById(long Id) {
        return categoryRepository.findById(Id);
    }

    @Override
    public Category findByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
}
