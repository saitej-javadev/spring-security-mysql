package com.saitej.springsecuritymysql.bootstrap;

import com.saitej.springsecuritymysql.model.User;
import com.saitej.springsecuritymysql.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Slf4j
@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User().builder().username("sam").password(new BCryptPasswordEncoder().encode("sam")).build();
        User user2 = new User().builder().username("tom").password(new BCryptPasswordEncoder().encode("tom")).build();
        userRepository.saveAll(Arrays.asList(user1,user2));
        log.info("Data Loaded with count: {} ",userRepository.count());

    }
}
