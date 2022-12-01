package com.areeba.pos.repository;

import com.areeba.pos.entity.Cart;
import com.areeba.pos.entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    Cart findById(long cartId);

}
