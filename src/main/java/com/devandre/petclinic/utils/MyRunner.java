package com.devandre.petclinic.utils;

import com.devandre.petclinic.repository.UserRepository;

/**
 * andre on 11/10/2023
 */
public class MyRunner {

    private final UserRepository userRepository;

    public MyRunner(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*public void run(String... args) throws Exception {
        System.out.println("MyRunner.run");
        System.out.println("userRepository = " + userRepository);
    }*/
}
