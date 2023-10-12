package com.devandre.petclinic.repository;

import com.devandre.petclinic.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {
}