package com.devandre.petclinic.repository;

import com.devandre.petclinic.entity.MedicineStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineStockRepository extends JpaRepository<MedicineStock, Long> {
}