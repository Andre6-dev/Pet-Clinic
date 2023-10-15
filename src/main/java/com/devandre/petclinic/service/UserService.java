package com.devandre.petclinic.service;

import com.devandre.petclinic.dao.UserDao;
import com.devandre.petclinic.entity.User;
import com.devandre.petclinic.exception.DuplicateResourceException;
import com.devandre.petclinic.exception.GenericException;
import com.devandre.petclinic.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * andre on 14/10/2023
 */
@Slf4j
@Service
@Transactional
public class UserService {

    private final UserDao userDao;

    public UserService(@Qualifier("user-jpa") UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> findAllUsers() {
        return userDao.selectAllUsers();
    }

    public User findUserById(Long id) {
        return userDao.selectUserById(id).orElseThrow(() -> new ResourceNotFoundException("User with id [%s] not found".formatted(id)));
    }

    public User createUser(User user) {
        try {
            // Check if user with email already exists
            String email = user.getEmail();
            if (userDao.existsUserWithEmail(email)) {
                throw new DuplicateResourceException("User with email [%s] already exists".formatted(email));
            }
            userDao.assignRoleToUser(email, "USER");
            log.info("User with email [%s] created successfully".formatted(email));
            return userDao.createUser(user);
        } catch (Exception e) {
            log.error("Error creating user with email [{}]: {}", user.getEmail(), e.getMessage());
            throw new GenericException(e.getMessage());
        }

    }
}
