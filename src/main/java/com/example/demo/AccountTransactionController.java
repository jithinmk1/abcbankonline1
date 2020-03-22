package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class AccountTransactionController {
    final
    @Autowired
    AccountTransactionRepository transactionRepository;

    public AccountTransactionController(AccountTransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @GetMapping("/account_transactions")
    public List<AccountTransaction> getAllAccountTransaction(){
        return transactionRepository.findAll();
    }

    @GetMapping("/account_transactions/{account_id}")
    public Optional<AccountTransaction> getAllBookById(@PathVariable(value="account_id")Integer account_id)
    {
        return transactionRepository.findById(account_id);
    }

    @PostMapping("/account_transactions")
    public @Valid AccountTransaction CreateAccountTransaction(@Valid @RequestBody AccountTransaction accountTransaction)
    {
        return transactionRepository.save(accountTransaction);
    }


    @PutMapping("/account_transactions/{account_id}")
    public @Valid AccountTransaction updateAccounttransactionById(@PathVariable(value="account_id")Integer account_id, @Valid @RequestBody AccountTransaction accountTransaction) throws AccountTransactionNotFoundException {
        AccountTransaction t1 = transactionRepository.findById(account_id).orElseThrow(() -> new AccountTransactionNotFoundException(account_id));
        t1.setTransaction_no(accountTransaction.getTransaction_no());
        t1.setTransaction_date(accountTransaction.getTransaction_date());
        t1.setTransaction_amount(accountTransaction.getTransaction_amount());
        t1.setAccount_id(accountTransaction.getAccount_id());
        t1.setLoan_id(accountTransaction.getLoan_id());
        t1.setPayee_id(accountTransaction.getPayee_id());
        t1.setTransaction_type(accountTransaction.getTransaction_type());
        AccountTransaction updTransaction=transactionRepository.save(t1);
        return updTransaction;

    }

    @DeleteMapping("/account_transactions/{account_id}")
    public ResponseEntity<?> deleteAccountTransaction(@PathVariable(value = "account_id") int account_id) throws AccountTransactionNotFoundException {
        AccountTransaction t2 = transactionRepository.findById(account_id)
                .orElseThrow(() -> new AccountTransactionNotFoundException(account_id));

        transactionRepository.delete(t2);
        return ResponseEntity.ok().build();
    }
}
