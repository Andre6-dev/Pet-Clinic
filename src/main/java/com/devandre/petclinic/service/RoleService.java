package com.devandre.petclinic.service;

import com.devandre.petclinic.dao.RoleDao;
import com.devandre.petclinic.entity.Role;
import com.devandre.petclinic.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * andre on 9/10/2023
 */
@Service
@Transactional
public class RoleService {

    private final RoleDao roleDao;

    public RoleService(@Qualifier("jpa") RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public List<Role> findAllRoles() {
        return roleDao.findAllRoles();
    }

    public Role findRoleByName(Long roleId) {
        return roleDao.selectRoleById(roleId).orElseThrow(() -> new ResourceNotFoundException("Role with id [%s] not found".formatted(roleId)));
    }

}
