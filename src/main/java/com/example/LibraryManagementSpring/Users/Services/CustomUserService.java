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

    public CustomUser setUserRole(CustomUser user){
        CustomUser customUser = customUserRepository.findCustomUserByUsername(user.getUsername()).orElseThrow(
                ()-> new UsernameNotFoundException("user doesnt exist")
        );
        if(roleRepository.existsByRoleName(user.getRole().getRoleName())){
            System.out.println(user.toString() );
            customUser.setRole(user.getRole());
            return customUserRepository.save(customUser);
        }
        throw new IllegalStateException("role doesn't exist");

    }

    public CustomUser deactivateUser(CustomUser userInstance) {
        System.out.println(userInstance.toString());
        CustomUser user = customUserRepository.findCustomUserByUsername(userInstance.getUsername()).orElseThrow(
                ()-> new UsernameNotFoundException("user doesnt exist")
        );
        user.setActive(false);
        return customUserRepository.save(user);
    }

    public void deleteUserByEmail(CustomUser userInstance){
        CustomUser user=customUserRepository.findCustomUserByEmail(userInstance.getEmail()).orElseThrow(
                ()-> new IllegalStateException("user not found")
        );
        customUserRepository.delete(user);
    }
    public CustomUser createNewUser(CustomUser user){
        return customUserRepository.save(user);
    }

}
