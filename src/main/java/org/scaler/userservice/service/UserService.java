package org.scaler.userservice.service;

import org.scaler.userservice.models.User;
import org.scaler.userservice.repository.UserRepo;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserService {

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private UserRepo userRepo;
    UserService(BCryptPasswordEncoder bCryptPasswordEncoder,
                UserRepo userRepo){
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepo = userRepo;
    }

    public User signUp(String email, String password,
                       String name){

        User u = new User();
        u.setEmail(email);
        u.setVerified(false);
        u.setName(name);
        u.setHashedPassword(bCryptPasswordEncoder.encode(password));

        return userRepo.save(u);
    }
}
