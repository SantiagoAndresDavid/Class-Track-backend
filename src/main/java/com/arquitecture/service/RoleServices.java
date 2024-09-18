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

    public boolean doAllRolesExist(List<Role> roles) {
        try {
            for (Role role : roles) {
                if (!roleRepository.existsById(role.getId())) {
                    throw new Exception("Role with ID " + role.getId() + " does not exist");
                }
            }
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}
