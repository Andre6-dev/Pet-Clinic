package com.devandre.petclinic.entity;

import com.devandre.petclinic.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * andre on 8/10/2023
 */
@Entity
@Table(name = "medicine_procedure")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MedicalProcedure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medical_procedure_id")
    private Long medicalProcedureId;
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private String description;
    private String notes;
    private String remarks;
    private Status status;
    @Column(name = "next_due_date")
    private LocalDateTime nextDueDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pet_id", referencedColumnName = "pet_id",nullable = false)
    @ToString.Exclude
    private Pet pet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medicine_stock_id", referencedColumnName = "medicine_stock_id",nullable = false)
    @ToString.Exclude
    private MedicineStock medicineStock;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicalProcedure that = (MedicalProcedure) o;
        return Objects.equals(medicalProcedureId, that.medicalProcedureId) && Objects.equals(createdAt, that.createdAt) && Objects.equals(description, that.description) && Objects.equals(notes, that.notes) && Objects.equals(remarks, that.remarks) && status == that.status && Objects.equals(nextDueDate, that.nextDueDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(medicalProcedureId, createdAt, description, notes, remarks, status, nextDueDate);
    }
}
