package com.areeba.pos.repository;

import com.areeba.pos.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Items, Long> {

    Items findById(long id);

    Items findByName(String name);

    Items findByCategory(String category);

}
