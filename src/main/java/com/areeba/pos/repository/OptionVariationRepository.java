package com.areeba.pos.repository;

import com.areeba.pos.entity.OptionVariations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionVariationRepository extends JpaRepository<OptionVariations, Long> {

    OptionVariations findById(long Id);

    OptionVariations findByName(String name);

}
