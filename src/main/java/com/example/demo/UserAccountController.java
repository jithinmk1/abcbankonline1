package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class UserAccountController {

    @Autowired
    UserAccountRepository userAccountRepository;

    public UserAccountController(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @GetMapping("/user_account")
    public List<UserAccount> getAllUserAccount() {
        return userAccountRepository.findAll();
    }

    @GetMapping("/user_account/{user_id}")
    public Optional<UserAccount> getAllUserAccountById(@PathVariable(value = "user_id") Integer user_id) {
        return userAccountRepository.findById(user_id);
    }

    @PostMapping("/user_account")
    public @Valid UserAccount CreateUserAccount(@Valid @RequestBody UserAccount userAccount) {
        return userAccountRepository.save(userAccount);
    }}
