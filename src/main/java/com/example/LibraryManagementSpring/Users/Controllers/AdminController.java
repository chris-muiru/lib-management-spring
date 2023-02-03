package com.example.LibraryManagementSpring.Users.Controllers;

import com.example.LibraryManagementSpring.Users.Models.CustomUser;
import com.example.LibraryManagementSpring.Users.Repositories.CustomUserRepository;
import com.example.LibraryManagementSpring.Users.Services.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/admin")
public class AdminController{
    @Autowired
    private CustomUserService customUserService;

    @GetMapping
    public List<CustomUser> getAllCustomUsers(){
        return customUserService.fetchAllCustomUsers();
    }

    @PostMapping("set-role/")
    public CustomUser assignUserRole(@RequestBody String username,@RequestBody String role){
        return customUserService.setUserRole(username,role);
    }
   @PostMapping("deactivate/")
    public CustomUser deactivateUser(@RequestBody String username){
       return customUserService.deactivateUser(username);

    }
    @DeleteMapping
    public void deleteUserByEmail(@RequestBody String email){
         customUserService.deleteUserByEmail(email);
    }
}
