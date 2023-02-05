package com.example.LibraryManagementSpring.Users.Repositories;

import com.example.LibraryManagementSpring.Users.Entities.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CustomUserRepository extends JpaRepository<CustomUser,Integer> {
    Optional<CustomUser> findCustomUserByUsername(String username);

//    @Query("select c from CustomUser c where c.email=?1")
    Optional<CustomUser> findCustomUserByEmail(String email);
}
