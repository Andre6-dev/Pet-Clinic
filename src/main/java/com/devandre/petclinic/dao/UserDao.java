package com.devandre.petclinic.dao;

import com.devandre.petclinic.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    List<User> selectAllUsers();
    Optional<User> selectUserById(Long id);
    User createUser(User user);
    Optional<User> selectUserByEmail(String email);
    void assignRoleToUser(String email, String roleName);
    boolean existsUserWithEmail(String email);
    boolean existsUserWithId(Long id);
    void deleteUserById(Long id);
    void updateUser(User user);

}
