package com.jwt.myconfig;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (username.equals("Ashok"))
        {
            return new User("Ashok","ashoka",new ArrayList<>());
        }
        else
        {
            throw  new UsernameNotFoundException("User not found");
        }


    }
}
