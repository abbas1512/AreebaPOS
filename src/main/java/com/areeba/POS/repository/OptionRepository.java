package com.areeba.POS.repository;

import com.areeba.POS.entity.Options;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionRepository extends JpaRepository<Options, Long> {

    Options findById(long Id);

    Options findByName(String name);

}
