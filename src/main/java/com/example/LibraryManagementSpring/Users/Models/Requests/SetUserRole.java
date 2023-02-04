package com.example.LibraryManagementSpring.Users.Models.Requests;

import com.example.LibraryManagementSpring.Roles.Entities.Role;
import lombok.Data;

@Data
public class SetUserRole {
    String username;
    Role role;
}
