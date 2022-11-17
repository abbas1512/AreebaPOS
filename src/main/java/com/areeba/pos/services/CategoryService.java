package com.areeba.pos.services;

import com.areeba.pos.common.RestCommonResponse;
import com.areeba.pos.dto.CategoryDTO;
import com.areeba.pos.entity.Category;

public interface CategoryService {

    Category createCategory(CategoryDTO categoryDTO);

    RestCommonResponse updateCategory(long Id, CategoryDTO categoryDTO);

    RestCommonResponse deleteCategory(long Id);

    RestCommonResponse saveCategory(CategoryDTO categoryDTO, String name);

    Category findById(long Id);

    Category findByName(String name);

    RestCommonResponse getAll();

}
