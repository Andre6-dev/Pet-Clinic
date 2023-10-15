package com.devandre.petclinic.dao.impl;

import com.devandre.petclinic.dao.UserDao;
import com.devandre.petclinic.entity.Role;
import com.devandre.petclinic.entity.User;
import com.devandre.petclinic.exception.ResourceNotFoundException;
import com.devandre.petclinic.repository.RoleRepository;
import com.devandre.petclinic.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * andre on 9/10/2023
 */
@Repository("user-jpa")
public class UserDaoImpl implements UserDao {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserDaoImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }
    @Override
    public List<User> selectAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> selectUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> selectUserByEmail(String email) {
        return Optional.ofNullable(userRepository.findByEmail(email));
    }

    @Override
    public void assignRoleToUser(String email, String roleName) {
        User user = selectUserByEmail(email).orElseThrow(() -> new ResourceNotFoundException("User with email [%s] not found".formatted(email)));
        Role role = roleRepository.findByName(roleName);
        user.assignRoleToUSer(role);
    }

    @Override
    public boolean existsUserWithEmail(String email) {
        return false;
    }

    @Override
    public boolean existsUserWithId(Long id) {
        return false;
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }
}
