package com.example.LibraryManagementSpring.Roles.Controllers;

import com.example.LibraryManagementSpring.Roles.Models.Role;
import com.example.LibraryManagementSpring.Roles.Services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping
    public List<Role> getAllRoles(){
        return  roleService.getRoles();
    }
    @PostMapping ("/new")
   public Role createNewRole(@RequestBody Role role){
        return roleService.createRole(role);
    }

}
