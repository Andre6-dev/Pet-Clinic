package com.devandre.petclinic.repository;

import com.devandre.petclinic.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}