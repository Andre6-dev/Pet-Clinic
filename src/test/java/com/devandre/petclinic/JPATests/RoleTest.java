package com.devandre.petclinic.JPATests;

import com.devandre.petclinic.dao.RoleDao;
import com.devandre.petclinic.enums.RoleEnum;
import com.devandre.petclinic.repository.RoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
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
    private RoleDao roleDao;

    @Test
    @Rollback(value = false)
    void testCreateRole() {
        // Given
        String name = RoleEnum.ADMIN.name();
        // When
        roleDao.createRole(name);
        // Then
        var actual = roleDao.findRoleByName(name);
        assertThat(actual).isNotNull();
    }
}
