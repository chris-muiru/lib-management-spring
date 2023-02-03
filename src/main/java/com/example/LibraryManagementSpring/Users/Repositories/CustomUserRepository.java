package com.example.LibraryManagementSpring.Users.Repositories;

import com.example.LibraryManagementSpring.Users.Models.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CustomUserRepository extends JpaRepository<CustomUser,Integer> {
    Optional<CustomUser> findByUsername(String username);

    void deleteByEmail(String email);
}
