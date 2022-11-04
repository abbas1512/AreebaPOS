package com.areeba.POS.repository;

import com.areeba.POS.entity.ItemSales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemSalesRepository extends JpaRepository<ItemSales, Long> {

    ItemSales findById(long Id);

    ItemSales findByName(String name);

}
