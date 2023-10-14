package com.devandre.petclinic.controller;

import com.devandre.petclinic.dto.RoleDto;
import com.devandre.petclinic.entity.Role;
import com.devandre.petclinic.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * andre on 12/10/2023
 */
@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public ResponseEntity<List<RoleDto>> getRoles() {
        return ResponseEntity.ok(roleService.findAllRoles());
    }

    @GetMapping("{roleId}")
    public ResponseEntity<RoleDto> getRole(@PathVariable("roleId") Long roleId) {
        return ResponseEntity.ok(roleService.findRoleByName(roleId));
    }
}
