package com.example.LibraryManagementSpring.Roles.Services;

import com.example.LibraryManagementSpring.Roles.Models.Role;
import com.example.LibraryManagementSpring.Roles.Repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }
}
