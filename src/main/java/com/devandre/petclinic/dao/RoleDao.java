package com.devandre.petclinic.dao;

import com.devandre.petclinic.entity.Role;

public interface RoleDao {

    void createRole(String rolename);

    Role findRoleByName(String name);

}
