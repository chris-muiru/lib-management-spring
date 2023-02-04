package com.example.LibraryManagementSpring.Users.Services;

import com.example.LibraryManagementSpring.Roles.Entities.Role;
import com.example.LibraryManagementSpring.Roles.Repositories.RoleRepository;
import com.example.LibraryManagementSpring.Users.Entities.CustomUser;
import com.example.LibraryManagementSpring.Users.Repositories.CustomUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;

@Service
public class CustomUserService {

    @Autowired
    CustomUserRepository customUserRepository;
    @Autowired
    RoleRepository roleRepository;
    public List<CustomUser> fetchAllCustomUsers(){
        return customUserRepository.findAll();
    }

    public CustomUser setUserRole(CustomUser user) throws Exception {
        CustomUser customUser = customUserRepository.findByUsername(user.getUsername()).orElseThrow(
                ()-> new UsernameNotFoundException("user doesnt exist")
        );
        if(roleRepository.existsByRoleName(user.getRole().getRoleName())){
            System.out.println(user.toString());
            customUser.setRole(user.getRole());
            return customUserRepository.save(customUser);
        }
        throw new Exception("role doesn't exist");

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
