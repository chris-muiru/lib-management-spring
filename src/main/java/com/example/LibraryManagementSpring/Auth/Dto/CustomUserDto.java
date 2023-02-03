package com.example.LibraryManagementSpring.Auth.Dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class CustomUserDto {
    private String username;
    private String email;
    private String password;
}
