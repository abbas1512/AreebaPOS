package com.areeba.POS.repository;

import com.areeba.POS.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Items, Long> {

    Items findById(long Id);

    Items findByName(String name);

}
