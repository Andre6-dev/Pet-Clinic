package com.devandre.petclinic.repository;

import com.devandre.petclinic.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    boolean existsUserByEmail(String email);

    boolean existsUserByUserId(Long id);
}