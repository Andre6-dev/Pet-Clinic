package com.devandre.petclinic.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

/**
 * andre on 6/10/2023
 */
@Entity
@Table(name = "medicines")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long medicineId;

    @Column(name = "name", length = 45, nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false, length = 45)
    private String label;
    @Column(nullable = false, length = 45)
    private String label_volume;
    @Column(nullable = false, length = 45)
    private Double quantityPerStock;
    @Column(nullable = false, length = 150)
    private String code;
    @Column(nullable = false, length = 150)
    private String manufacturer;
    @Column(nullable = false, length = 150)
    private String supplier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id",nullable = false)
    @ToString.Exclude
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medicine_stock_id", referencedColumnName = "medicine_stock_id",nullable = false)
    @ToString.Exclude
    private MedicineStock medicineStock;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicine medicine = (Medicine) o;
        return Objects.equals(medicineId, medicine.medicineId) && Objects.equals(name, medicine.name) && Objects.equals(description, medicine.description) && Objects.equals(label, medicine.label) && Objects.equals(label_volume, medicine.label_volume) && Objects.equals(quantityPerStock, medicine.quantityPerStock) && Objects.equals(code, medicine.code) && Objects.equals(manufacturer, medicine.manufacturer) && Objects.equals(supplier, medicine.supplier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(medicineId, name, description, label, label_volume, quantityPerStock, code, manufacturer, supplier);
    }
}
