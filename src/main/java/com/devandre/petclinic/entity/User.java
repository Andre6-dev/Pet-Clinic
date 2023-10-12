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
@Table(
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "users_email_unique",
                        columnNames = "email"
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    @Id
    @Column(name = "user_id")
    @SequenceGenerator(
            name = "user_id_seq",
            sequenceName = "user_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "user_id_seq"
    )
    private Long userId;
    @Column(name = "first_name", length = 45)
    private String firstName;
    @Column(name = "last_name", length = 45)
    private String lastName;
    @Column(nullable = false, length = 45)
    private String email;
    @Column(name = "contact_number", length = 12)
    private String contactNumber;
    @Column(nullable = false, length = 64)
    private String password;
    @Column(name = "profile_image_url")
    private String profileImageUrl;
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToMany(
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(
                    name = "user_id",
                    referencedColumnName = "user_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id",
                    referencedColumnName = "role_id"
            )
    )
    private Set<Role> roles = new HashSet<>();

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    @ToString.Exclude
    private Set<Medicine> medicines = new HashSet<>();

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    @ToString.Exclude
    private Set<MedicineStock> medicineStocks = new HashSet<>();

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Client client;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Veterinarian veterinarian;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(email, user.email) && Objects.equals(contactNumber, user.contactNumber) && Objects.equals(password, user.password) && Objects.equals(profileImageUrl, user.profileImageUrl) && Objects.equals(createdAt, user.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, lastName, email, contactNumber, password, profileImageUrl, createdAt);
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void assignRoleToUSer(Role role) {
        this.roles.add(role);
        role.getUsers().add(this);
    }

    public void removeRoleFromUser(Role role) {
        this.roles.remove(role);
        role.getUsers().remove(this);
    }
}
