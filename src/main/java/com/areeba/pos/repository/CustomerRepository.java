package com.areeba.pos.repository;

import com.areeba.pos.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customers, Long> {

    Customers findById(long Id);

    Customers findByName(String name);

}
