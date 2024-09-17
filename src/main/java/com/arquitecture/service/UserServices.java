package com.arquitecture.service;

import com.arquitecture.data.UserRepository;
import com.arquitecture.entity.Role;
import com.arquitecture.entity.User;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;


@Singleton
public class UserServices {
    @Inject
    UserRepository userRepository;
    @Inject
    RoleServices roleServices;


    public String saveUserWithRoles(User user) {
        try {
            //verify if all roles exist

            roleServices.doAllRolesExist(user.getRoles());
            // Encrypt the user's password
            User userEncrypt = encryptPassword(user);
            // Save the user with roles
            userRepository.save(userEncrypt);
            return "User saved with roles";
        } catch (Exception e) {
            return "Error saving User: " + e.getMessage();
        }
    }

    public User encryptPassword(User user) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return user;
    }
}
