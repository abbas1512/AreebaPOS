package com.areeba.pos.repository;

import com.areeba.pos.entity.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Long> {

    Business findById(long id);

    Business findByName(String name);

}
