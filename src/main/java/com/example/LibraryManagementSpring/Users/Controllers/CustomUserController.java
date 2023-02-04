package com.example.LibraryManagementSpring.Users.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/users")
public class CustomUserController {
//    @Autowired
    @GetMapping
    public String getAText(){
        return "This is a test";
    }

}
