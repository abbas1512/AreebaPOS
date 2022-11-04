package com.areeba.POS.repository;

import com.areeba.POS.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findById(long Id);
    User findByEmail(String email);

}
