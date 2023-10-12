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
@Table(name = "pets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_id")
    private Long petId;

    @Column(name = "name", length = 45, nullable = false)
    private String name;
    @Column(name = "photo_url")
    private String photoUrl;
    @Column(name = "breed", length = 45)
    private String breed;
    @Column(name = "species", length = 45, nullable = false)
    private String species;
    @Column(name = "birth_date", nullable = false)
    private LocalDateTime birthDate;
    @Column(length = 12)
    private String gender;
    @Column(length = 45)
    private String color;
    @Column(name = "microchip_id", length = 45)
    private String microchipId;
    @Column(length = 45)
    private String weight;
    @Column(name = "next_visit")
    private LocalDateTime nextVisit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", referencedColumnName = "client_id",nullable = false)
    @ToString.Exclude
    private Client client;

    @OneToMany(
            mappedBy = "pet",
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
        Pet pet = (Pet) o;
        return Objects.equals(petId, pet.petId) && Objects.equals(name, pet.name) && Objects.equals(photoUrl, pet.photoUrl) && Objects.equals(breed, pet.breed) && Objects.equals(species, pet.species) && Objects.equals(birthDate, pet.birthDate) && Objects.equals(gender, pet.gender) && Objects.equals(color, pet.color) && Objects.equals(microchipId, pet.microchipId) && Objects.equals(weight, pet.weight) && Objects.equals(nextVisit, pet.nextVisit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(petId, name, photoUrl, breed, species, birthDate, gender, color, microchipId, weight, nextVisit);
    }
}
