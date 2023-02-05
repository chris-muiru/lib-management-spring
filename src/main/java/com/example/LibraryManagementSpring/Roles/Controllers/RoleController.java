package com.example.LibraryManagementSpring.Roles.Controllers;

import com.example.LibraryManagementSpring.Roles.Entities.Role;
import com.example.LibraryManagementSpring.Roles.Models.Request.RoleRequest;
import com.example.LibraryManagementSpring.Roles.Services.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Role createNewRole(@RequestBody RoleRequest role){
        ModelMapper modelMapper = new ModelMapper();
        Role roleMapped = modelMapper.map(role,Role.class);
        return roleService.createRole(roleMapped);
    }
    @PutMapping("/mutate")
    public Role updateRole(@RequestBody RoleRequest roleRequest,@PathVariable Integer roleId){
        ModelMapper modelMapper=new ModelMapper();
        Role roleMapped = modelMapper.map(roleRequest,Role.class);
        return roleService.updateRoleById(roleMapped,roleId);
    }
}
