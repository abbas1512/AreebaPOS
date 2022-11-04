package com.areeba.POS.repository;

import com.areeba.POS.entity.Taxes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxRepository extends JpaRepository<Taxes, Long> {

    Taxes findById(long Id);

    Taxes findByName(String name);

}
