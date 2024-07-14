package com.prototype.nails_courses.controller;

import com.prototype.nails_courses.entity.User;
import com.prototype.nails_courses.service.UserAccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserAccountController {
    private UserAccountService userAccountService;

    @Autowired
    public UserAccountController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @GetMapping("/status")
    public ResponseEntity<?> getStatus() {
        return new ResponseEntity<>("Server is up!", HttpStatus.OK);
    }

    @PostMapping("/createAccount")
    public ResponseEntity<?> createUserAccount(@Valid @RequestBody User user) {
        return userAccountService.createUserAccount(user);
    }


}
