package com.devandre.petclinic.dao.impl;

import com.devandre.petclinic.dao.UserDao;
import com.devandre.petclinic.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * andre on 9/10/2023
 */
public class UserDaoImpl implements UserDao {
    @Override
    public List<User> selectAllUsers() {
        return null;
    }

    @Override
    public Optional<User> selectUserById(Long id) {
        return Optional.empty();
    }

    @Override
    public void insertUser(User user) {

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

    }

    @Override
    public void updateUser(User user) {

    }
}
