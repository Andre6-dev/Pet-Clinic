package com.devandre.petclinic.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * andre on 8/10/2023
 */
@Entity
@Table(name = "clients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Client {

    @Id
    @Column(name = "client_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    @Column(name = "first_name", length = 45)
    private String firstname;
    @Column(name = "last_name", length = 45)
    private String lastname;
    @Column(nullable = false, length = 45, unique = true)
    private String email;
    @Column(nullable = false, length = 3)
    private Integer age;
    @Column(name = "contact_number", length = 12)
    private String contactNumber;
    @Column
    private String address;
    @Column
    private String gender;
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @OneToMany(
            mappedBy = "client",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    @ToString.Exclude
    private Set<Pet> pets = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(clientId, client.clientId) && Objects.equals(firstname, client.firstname) && Objects.equals(lastname, client.lastname) && Objects.equals(email, client.email) && Objects.equals(age, client.age) && Objects.equals(contactNumber, client.contactNumber) && Objects.equals(address, client.address) && Objects.equals(gender, client.gender) && Objects.equals(createdAt, client.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, firstname, lastname, email, age, contactNumber, address, gender, createdAt);
    }
}
