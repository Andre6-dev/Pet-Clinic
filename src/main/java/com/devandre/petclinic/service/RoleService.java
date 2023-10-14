package com.devandre.petclinic.service;

import com.devandre.petclinic.dao.RoleDao;
import com.devandre.petclinic.dto.RoleDto;
import com.devandre.petclinic.entity.Role;
import com.devandre.petclinic.exception.ResourceNotFoundException;
import com.devandre.petclinic.mapper.RoleMapper;
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
    private final RoleMapper roleMapper;

    public RoleService(@Qualifier("jpa") RoleDao roleDao, RoleMapper roleMapper) {
        this.roleDao = roleDao;
        this.roleMapper = roleMapper;
    }

    public List<RoleDto> findAllRoles() {
        List<Role> roles = roleDao.findAllRoles();
        return roleMapper.toListDto(roles);
    }

    public RoleDto findRoleByName(Long roleId) {
        Role role = roleDao.selectRoleById(roleId).orElseThrow(() -> new ResourceNotFoundException("Role with id [%s] not found".formatted(roleId)));
        return roleMapper.toDto(role);
    }

}
