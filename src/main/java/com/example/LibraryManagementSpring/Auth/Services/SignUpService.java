package com.example.LibraryManagementSpring.Auth.Services;

import com.example.LibraryManagementSpring.Auth.Dto.CustomUserDto;
import com.example.LibraryManagementSpring.Users.Models.CustomUser;
import com.example.LibraryManagementSpring.Users.Repositories.CustomUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SignUpService {
    @Autowired
    CustomUserRepository customUserRepository;

    public CustomUser signUpUser(CustomUser user){
        Optional<CustomUser> userExist = customUserRepository.findByUsername(user.getUsername());
        return userExist.orElseGet(() -> customUserRepository.save(user));
    }
}
