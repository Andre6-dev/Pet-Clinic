package com.devandre.petclinic.dao.impl;

import com.devandre.petclinic.dao.RoleDao;
import com.devandre.petclinic.entity.Role;
import com.devandre.petclinic.repository.RoleRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * andre on 9/10/2023
 */
@Repository("jpa")
public class RoleDaoImpl implements RoleDao {

    private final RoleRepository roleRepository;

    public RoleDaoImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    public List<Role> findAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public void createRole(String rolename) {
        var role = new Role();
        role.setName(rolename);
        roleRepository.save(role);
    }

    @Override
    public Optional<Role> selectRoleById(Long id) {
        return roleRepository.findById(id);
    }

}
