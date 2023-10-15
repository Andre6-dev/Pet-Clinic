package com.devandre.petclinic.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Objects;

/**
 * andre on 14/10/2023
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_profile_id")
    private Long userProfileId;
    @Column(name = "first_name", length = 45)
    private String firstName;
    @Column(name = "last_name", length = 45)
    private String lastName;
    @Column(nullable = false, length = 45)
    private String email;
    @Column(nullable = false, length = 12)
    private String contactNumber;
    private String address;
    private String gender;
    @Column(name = "birth_date")
    private Date birthDate;
    @Column(name = "profile_image_url")
    private String profileImageUrl;

    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private Client client;

    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private Veterinarian veterinarian;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfile that = (UserProfile) o;
        return Objects.equals(userProfileId, that.userProfileId) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(contactNumber, that.contactNumber) && Objects.equals(address, that.address) && Objects.equals(gender, that.gender) && Objects.equals(birthDate, that.birthDate) && Objects.equals(profileImageUrl, that.profileImageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userProfileId, firstName, lastName, contactNumber, address, gender, birthDate, profileImageUrl);
    }
}
