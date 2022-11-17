package com.areeba.pos.repository;

import com.areeba.pos.entity.Variations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VariationRepository extends JpaRepository<Variations, Long> {

    Variations findById(long Id);

    Variations findByName(String name);

}
