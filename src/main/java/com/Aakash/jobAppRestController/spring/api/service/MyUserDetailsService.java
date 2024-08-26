package com.Aakash.jobAppRestController.spring.api.service;

import com.Aakash.jobAppRestController.spring.api.model.UserPrinciple;
import com.Aakash.jobAppRestController.spring.api.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import com.Aakash.jobAppRestController.spring.api.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = repo.findByUsername(username);


        if(user ==null){
            System.out.println("user 404");
            throw new UsernameNotFoundException("user 404");
        }
        return new UserPrinciple(user);
    }
}
