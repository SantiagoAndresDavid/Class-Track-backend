package com.arquitecture.service;
import com.arquitecture.data.RoleRepository;
import com.arquitecture.entity.Role;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class RoleServices{
    @Inject
    RoleRepository roleRepository;

    public Iterable<Role> getAllRoles() {return roleRepository.findAll();}

}
