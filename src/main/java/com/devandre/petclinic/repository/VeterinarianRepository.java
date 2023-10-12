package com.devandre.petclinic.repository;

import com.devandre.petclinic.entity.Veterinarian;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeterinarianRepository extends JpaRepository<Veterinarian, Long> {
}