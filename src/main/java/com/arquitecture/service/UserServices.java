package com.arquitecture.service;

import com.arquitecture.data.UserRepository;
import com.arquitecture.entity.Grade;
import com.arquitecture.entity.User;
import io.micronaut.core.annotation.NonNull;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Singleton
public class UserServices {
    @Inject
    UserRepository userRepository;
    @Inject
    RoleServices roleServices;


    public String saveUser(User user) {
        try {
            //verify if all roles exist
            if (!roleServices.doAllRolesExist(user.getRoles())) {
                throw new Exception("Roles do not exist");
            }
            // Encrypt the user's password
            User userEncrypt = encryptPassword(user);
            // Save the user with roles
            userRepository.save(userEncrypt);
            return "User saved with roles";
        } catch (Exception e) {
            return "Error saving User: " + e.getMessage();
        }
    }

    public @NonNull User getUserById(String email) {
        try {
            User userResponse = userRepository.findByName(email);
            userResponse.setRoles(userRepository.findDistinctRolesById(userResponse.getId()));
               return userResponse;
        } catch (Exception e) {
            // Handle the exception or log it
            return null;
        }
    }

    public User getUserByEmail(String email) {
        try {
            String email2 = "string";
            User user =  userRepository.findByName(email2);
            return user;
        } catch (Exception e) {
            // Handle the exception or log it
            return null;
        }
    }

    public boolean singIn(String email, String password) {
        try {
            User userResponse = userRepository.findByEmail(email);
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            if (userResponse != null && passwordEncoder.matches(password, userResponse.getPassword())) {
                return true;
            }
        } catch (Exception e) {
            // Handle the exception or log it
        }
        return false;
    }

    public User encryptPassword(User user) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return user;
    }

    public String addGradeToUser(Long id, List<Grade> grades) {
        try {
            return "Class added to user";
        } catch (Exception e) {
            return "Error adding class to user: " + e.getMessage();
        }
    }

    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (user.getRoles() == null) {
                user.setRoles(new ArrayList<>());
            }
        }
        return users;
    }
}
