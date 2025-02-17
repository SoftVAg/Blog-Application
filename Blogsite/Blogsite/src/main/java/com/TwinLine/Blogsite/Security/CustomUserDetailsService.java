package com.TwinLine.Blogsite.Security;

import com.TwinLine.Blogsite.Repo.UserRepo;
import com.TwinLine.Blogsite.entity.User;
import com.TwinLine.Blogsite.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // loading user from databases by username
        User user = this.userRepo.findByEmail(username).orElseThrow(()-> new ResourceNotFoundException("User","email: "+username,0));
        return user;
    }
}
