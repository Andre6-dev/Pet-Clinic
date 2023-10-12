package com.devandre.petclinic.dao.impl;

import com.devandre.petclinic.dao.RoleDao;
import com.devandre.petclinic.entity.Role;
import com.devandre.petclinic.repository.RoleRepository;
import org.springframework.stereotype.Repository;

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
    public void createRole(String rolename) {
        var role = new Role();
        role.setName(rolename);
        roleRepository.save(role);
    }

    @Override
    public Role findRoleByName(String name) {
        return roleRepository.findByName(name);
    }
}
