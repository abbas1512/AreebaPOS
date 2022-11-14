package com.areeba.POS.services.Impl;

import com.areeba.POS.common.ErrorResponseApisEnum;
import com.areeba.POS.common.RestCommonResponse;
import com.areeba.POS.dto.CategoryDTO;
import com.areeba.POS.entity.Category;
import com.areeba.POS.repository.CategoryRepository;
import com.areeba.POS.services.CategoryService;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.BadRequestException;
import java.util.List;
import java.util.logging.Logger;

@Service("CategoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private final CategoryRepository categoryRepository;
    private static final Logger log = (Logger) LoggerFactory.getLogger(CategoryServiceImpl.class);

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category createCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setItemId(categoryDTO.getItemId());
        category.setName(categoryDTO.getName());
        return categoryRepository.save(category);
    }

    @Override
    public RestCommonResponse updateCategory(long Id, CategoryDTO categoryDTO) {
        if (this.categoryRepository.findById(Id) != null) {
            Category categoryById = this.categoryRepository.findById(Id);
            categoryById.setItemId(categoryDTO.getItemId());
            categoryById.setName(categoryDTO.getName());
            Category updatedCategory = this.categoryRepository.save(categoryById);
            return new RestCommonResponse(true, new Category(
                    updatedCategory.getItemId(),
                    updatedCategory.getName()
            ));
        } else {
            return new RestCommonResponse(false, new BadRequestException(String.valueOf
                    (ErrorResponseApisEnum.DoesntExist)));
        }
    }

    @Override
    public RestCommonResponse deleteCategory(long Id) {
        if (this.categoryRepository.findById(Id) != null) {
            this.categoryRepository.deleteById(Id);
            return new RestCommonResponse(true, "Deleted");
        } else {
            return new RestCommonResponse(false, new BadRequestException(String.valueOf
                    (ErrorResponseApisEnum.DoesntExist)));
        }
    }

    @Override
    public RestCommonResponse saveCategory(CategoryDTO categoryDTO, String name) {
        Category category = this.categoryRepository.findByName(name);
        if (category == null) {
            log.info("Saving category to the database");
            return new RestCommonResponse(true, this.categoryRepository.save(category));
        } else {
            return new RestCommonResponse(false, new BadRequestException(String.valueOf
                    (ErrorResponseApisEnum.AlreadyRegistered)));
        }
    }

    @Override
    public Category findById(long Id) {
        log.info("Fetching category");
        return this.categoryRepository.findById(Id);
    }

    @Override
    public Category findByName(String name) {
        log.info("Fetching category");
        return this.categoryRepository.findByName(name);
    }

    @Override
    public RestCommonResponse getAll() {
        log.info("Fetching all Categories");
        List<Category> category = this.categoryRepository.findAll();
        return new RestCommonResponse(true, category);
    }
}
