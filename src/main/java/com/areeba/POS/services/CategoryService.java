package com.areeba.POS.services;


import com.areeba.POS.dto.CategoryDTO;
import com.areeba.POS.entity.Category;

import java.util.List;

public interface CategoryService {

    void createCategory(CategoryDTO categoryDTO) throws Exception;

    void updateCategory(CategoryDTO categoryDTO, long Id);

    void deleteCategory(long Id);

    Category findById(long Id);

    Category findByName(String name);

    List<Category> getAll();

}
