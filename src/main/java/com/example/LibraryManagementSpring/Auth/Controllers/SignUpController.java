package com.example.LibraryManagementSpring.Auth.Controllers;

import com.example.LibraryManagementSpring.Auth.Services.SignUpService;
import com.example.LibraryManagementSpring.Users.Entities.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/auth")
public class SignUpController {
    @Autowired
    SignUpService signUpService;

    @PostMapping(path="/sign-up/")
    public CustomUser signUpUser(@RequestBody CustomUser user){
        System.out.println(user.toString());
        return signUpService.signUpUser(user);
    }
}
