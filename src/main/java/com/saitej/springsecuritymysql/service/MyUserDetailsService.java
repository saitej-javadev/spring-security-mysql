						package com.saitej.springsecuritymysql.service;

import com.saitej.springsecuritymysql.config.UserPrinciple;
import com.saitej.springsecuritymysql.model.User;
import com.saitej.springsecuritymysql.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repo;

    @Override
    public UserPrinciple loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> byUsername = repo.findByUsername(username);
        byUsername.orElseThrow(()->new UsernameNotFoundException(byUsername+"not found"));

        return new UserPrinciple(byUsername.get());
    }
}
