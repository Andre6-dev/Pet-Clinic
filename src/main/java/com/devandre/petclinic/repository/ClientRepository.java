package com.devandre.petclinic.repository;

import com.devandre.petclinic.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}