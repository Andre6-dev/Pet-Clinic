package com.devandre.petclinic.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * andre on 6/10/2023
 */
@Entity
@Table(name = "medicine_stocks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MedicineStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicine_stock_id")
    private Long medicineStockId;
    private Double quantity;
    @Column(name = "out_whole")
    private Double outWhole;
    @Column(name = "out_fraction")
    private Double outFraction;
    @Column(name = "expiry_date")
    private LocalDateTime expiryDate;

    @OneToMany(
            mappedBy = "medicineStock",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    @ToString.Exclude
    private Set<Medicine> medicines = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id",nullable = false)
    @ToString.Exclude
    private User user;

    @OneToMany(
            mappedBy = "medicineStock",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    @ToString.Exclude
    private Set<MedicalProcedure> medicalProcedures = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicineStock that = (MedicineStock) o;
        return Objects.equals(medicineStockId, that.medicineStockId) && Objects.equals(quantity, that.quantity) && Objects.equals(outWhole, that.outWhole) && Objects.equals(outFraction, that.outFraction) && Objects.equals(expiryDate, that.expiryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(medicineStockId, quantity, outWhole, outFraction, expiryDate);
    }
}
