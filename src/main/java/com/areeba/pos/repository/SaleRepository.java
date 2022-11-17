package com.areeba.pos.repository;

import com.areeba.pos.entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sales, Long> {

    Sales findById(long Id);

}
