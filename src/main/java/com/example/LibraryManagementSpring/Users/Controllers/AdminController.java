package com.example.LibraryManagementSpring.Users.Controllers;

import com.example.LibraryManagementSpring.Roles.Entities.Role;
import com.example.LibraryManagementSpring.Users.Entities.CustomUser;
import com.example.LibraryManagementSpring.Users.Models.Requests.SetUserRole;
import com.example.LibraryManagementSpring.Users.Models.Requests.UserDetailsRequest;
import com.example.LibraryManagementSpring.Users.Services.CustomUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/admin")
    public class AdminController{
        @Autowired
    private CustomUserService customUserService;

    @GetMapping("/users")
    public List<CustomUser> getAllCustomUsers(){
        return customUserService.fetchAllCustomUsers();
    }

    @PostMapping("/users/set-role")
    public CustomUser assignUserRole(@RequestBody SetUserRole userDetails){
        ModelMapper modelMapper = new ModelMapper();
        CustomUser customUser = modelMapper.map(userDetails,CustomUser.class);
        System.out.println(customUser.toString());
        return customUserService.setUserRole(customUser);
    }
   @PostMapping("/users/deactivate")
    public CustomUser deactivateUser(@RequestBody String userDetails){
        ModelMapper modelMapper = new ModelMapper();
        CustomUser userInstance  = modelMapper.map(userDetails,CustomUser.class);
       return customUserService.deactivateUser(userInstance);
    }
    @DeleteMapping("/users/delete")
    public void deleteUserByEmail(@RequestBody UserDetailsRequest userDetails){
        ModelMapper modelMapper = new ModelMapper();
        CustomUser userInstance  = modelMapper.map(userDetails,CustomUser.class);
         customUserService.deleteUserByEmail(userInstance);
    }
}
