package com.areeba.POS.repository;

import com.areeba.POS.entity.Variations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VariationRepository extends JpaRepository<Variations, Long> {

    Variations findById(long Id);

    Variations findByName(String name);

}
