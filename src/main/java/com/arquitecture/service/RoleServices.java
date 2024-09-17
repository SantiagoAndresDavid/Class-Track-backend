package com.arquitecture.service;
import com.arquitecture.data.RoleRepository;
import com.arquitecture.entity.Role;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class RoleServices{
    @Inject
    RoleRepository roleRepository;

    public Iterable<Role> getAllRoles() {return roleRepository.findAll();}
    public String saveRole(Role role) {
        try {
            roleRepository.save(role);
            return "Role saved";
        } catch (Exception e) {
            return "Error saving role: " + e.getMessage();
        }
    }

    public void doAllRolesExist(List<Role> roles) {
        for (Role role : roles) {
            if (!roleRepository.existsById(role.getId())) {
                return;
            }
        }
    }
}
