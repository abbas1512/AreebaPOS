package com.areeba.POS.repository;

import com.areeba.POS.entity.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Long> {

    Business findById(long Id);

    Business findByName(String name);

}
