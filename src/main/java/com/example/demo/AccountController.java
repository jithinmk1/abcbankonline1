package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class AccountController {
    final
    @Autowired
    AccountRepository accountRepository;
    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping("/accounts")
    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }

    @GetMapping("/accounts/{id}")
    public Optional<Account> getAllAccountById(@PathVariable(value = "id") Integer id) {
        return accountRepository.findById(id);
    }

    @PostMapping("/accounts")
    public @Valid Account CreateAccount(@Valid @RequestBody Account account) {
        return accountRepository.save(account);
    }


    @PutMapping("/accounts/{id}")
    public @Valid Account updateAccountById(@PathVariable(value = "id") Integer id, @Valid @RequestBody Account account) throws AccountNotFoundException {
        Account b1 = accountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException(id));
        b1.setAccount_name(account.getAccount_name());
        b1.setAccount_type(account.getAccount_type());
        b1.setAccount_address(account.getAccount_address());
        b1.setAccount_status(account.getAccount_status());
        b1.setEmail_id(account.getEmail_id());
        b1.setMobile_number(account.getMobile_number());
        b1.setDate_open(account.getDate_open());
        b1.setDate_closed(account.getDate_closed());
        b1.setAccount_balance(account.getAccount_balance());
        Account updaccount = accountRepository.save(b1);
        return updaccount;

    }

    @DeleteMapping("/accounts/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable(value = "id") int Id) throws AccountNotFoundException {
        Account b2 = accountRepository.findById(Id)
                .orElseThrow(() -> new AccountNotFoundException(Id));

        accountRepository.delete(b2);
        return ResponseEntity.ok().build();
    }
}