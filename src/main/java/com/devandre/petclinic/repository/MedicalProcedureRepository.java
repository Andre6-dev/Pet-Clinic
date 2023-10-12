package com.devandre.petclinic.repository;

import com.devandre.petclinic.entity.MedicalProcedure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalProcedureRepository extends JpaRepository<MedicalProcedure, Long> {
}