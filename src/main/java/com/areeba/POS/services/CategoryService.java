package com.areeba.POS.services;

import com.areeba.POS.common.RestCommonResponse;
import com.areeba.POS.dto.CategoryDTO;
import com.areeba.POS.entity.Category;

public interface CategoryService {

    Category createCategory(CategoryDTO categoryDTO);

    RestCommonResponse updateCategory(long Id, CategoryDTO categoryDTO);

    RestCommonResponse deleteCategory(long Id);

    RestCommonResponse saveCategory(CategoryDTO categoryDTO, String name);

    Category findById(long Id);

    Category findByName(String name);

    RestCommonResponse getAll();

}
