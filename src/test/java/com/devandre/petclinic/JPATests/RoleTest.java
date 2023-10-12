package com.devandre.petclinic.JPATests;

import com.devandre.petclinic.dao.RoleDao;
import com.devandre.petclinic.entity.Role;
import com.devandre.petclinic.enums.RoleEnum;
import com.devandre.petclinic.repository.RoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * andre on 9/10/2023
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RoleTest {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    @Rollback(value = false)
    void testCreateRole() {
        // Given
        /*String name = RoleEnum.ADMIN.name();
        Role role = new Role(
                name
        );*/
        String roleUser = RoleEnum.USER.name();
        Role role = new Role(roleUser);
        // When
        roleRepository.save(role);
        // Then
        assertThat(role.getRoleId()).isGreaterThan(0);
    }
}
