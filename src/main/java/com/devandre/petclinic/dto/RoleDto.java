package com.devandre.petclinic.dto;

import com.devandre.petclinic.entity.Role;

import java.io.Serializable;

/**
 * DTO for {@link Role}
 */
public record RoleDto(Long roleId, String name) implements Serializable {
}