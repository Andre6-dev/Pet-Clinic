package com.devandre.petclinic.dao;

import com.devandre.petclinic.entity.Role;

import java.util.List;
import java.util.Optional;

public interface RoleDao {

    List<Role> findAllRoles();

    Optional<Role> selectRoleById(Long id);

}
