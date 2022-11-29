package com.areeba.pos.repository;

import com.areeba.pos.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    Set<Cart> findById(long id);

}
