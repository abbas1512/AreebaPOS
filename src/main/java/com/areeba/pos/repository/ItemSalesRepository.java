package com.areeba.pos.repository;

import com.areeba.pos.entity.ItemSales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemSalesRepository extends JpaRepository<ItemSales, Long> {

    ItemSales findById(long Id);

}
