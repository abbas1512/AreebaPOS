package com.areeba.pos.repository;

import com.areeba.pos.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findById(long Id);

    Category findByName(String name);

}
