package com.example.LibraryManagementSpring.Roles.Repositories;

import com.example.LibraryManagementSpring.Roles.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
}
