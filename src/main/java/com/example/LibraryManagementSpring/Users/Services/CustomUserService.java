package com.example.LibraryManagementSpring.Users.Services;

import com.example.LibraryManagementSpring.Roles.Models.Role;
import com.example.LibraryManagementSpring.Users.Models.CustomUser;
import com.example.LibraryManagementSpring.Users.Repositories.CustomUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserService {

    @Autowired
    CustomUserRepository customUserRepository;
    public List<CustomUser> fetchAllCustomUsers(){
        return customUserRepository.findAll();
    }

    public CustomUser setUserRole(String username,List<Role> role) throws UsernameNotFoundException {
        CustomUser user = customUserRepository.findByUsername(username).orElseThrow(
                ()-> new UsernameNotFoundException("user doesnt exist")
        );
        user.setRoles(role);
        return user;
    }

    public CustomUser deactivateUser(String username) {
        CustomUser user = customUserRepository.findByUsername(username).orElseThrow(
                ()-> new UsernameNotFoundException("user doesnt exist")
        );
        user.setActive(false);
        return user;
    }

    public void deleteUserByEmail(String email){
        customUserRepository.deleteByEmail(email);
    }
    public CustomUser createNewUser(CustomUser user){
        return customUserRepository.save(user);
    }

}
