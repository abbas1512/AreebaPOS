package com.areeba.POS.repository;

import com.areeba.POS.entity.Discounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends JpaRepository<Discounts, Long> {

    Discounts findById(long Id);

    Discounts findByName(String name);

}
