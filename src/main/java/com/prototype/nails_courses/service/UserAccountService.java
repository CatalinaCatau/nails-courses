package com.prototype.nails_courses.service;

import com.prototype.nails_courses.entity.User;
import com.prototype.nails_courses.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService {
    private UserAccountRepository userAccountRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserAccountService(UserAccountRepository userAccountRepository, PasswordEncoder passwordEncoder) {
        this.userAccountRepository = userAccountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public ResponseEntity<?> createUserAccount(User user) {
        ResponseEntity<?> response = null;
        user.setId(null);
        user.setRole("USER");
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        try {
            User insertedUser = userAccountRepository.saveAndFlush(user);
            response = new ResponseEntity<>(insertedUser, HttpStatus.CREATED);
        } catch (Exception e) {
            response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return response;
    }
}
