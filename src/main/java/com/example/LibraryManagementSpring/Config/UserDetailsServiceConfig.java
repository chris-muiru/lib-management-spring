package com.example.LibraryManagementSpring.Config;

import com.example.LibraryManagementSpring.Users.Entities.CustomUser;
import com.example.LibraryManagementSpring.Users.Repositories.CustomUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceConfig implements UserDetailsService {
    @Autowired
    CustomUserRepository customUserRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomUser user = customUserRepository.findCustomUserByUsername(username).orElseThrow(
                ()->new UsernameNotFoundException("User doesnt exist")
        );
        return new CustomUserDetails(user);
    }
}
