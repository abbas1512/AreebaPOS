package com.areeba.pos.repository;

import com.areeba.pos.entity.Discounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends JpaRepository<Discounts, Long> {

    Discounts findById(long id);

    Discounts findByName(String name);

}
