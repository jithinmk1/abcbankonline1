package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class LoanController {
    final
    @Autowired
    LoanRepository loanRepository;

    public LoanController(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @GetMapping("/loans")
    public List<Loan> getAllLoan() {
        return loanRepository.findAll();
    }

    @GetMapping("/loans/{loan_id}")
    public Optional<Loan> getAllLoanById(@PathVariable(value = "loan_id") Integer loan_id) {
        return loanRepository.findById(loan_id);
    }

    @PostMapping("/loans")
    public @Valid Loan CreateLoan(@Valid @RequestBody Loan loan) {
        return loanRepository.save(loan);
    }


    @PutMapping("/loans/{loan_id}")
    public @Valid Loan updateLoanById(@PathVariable (value = "loan_id") Integer loan_id, @Valid @RequestBody Loan loan) throws LoanNotFoundException {
        Loan l1 = loanRepository.findById(loan_id).orElseThrow(() -> new LoanNotFoundException(loan_id));
       l1.setLoan_type(loan.getLoan_type());
        l1.setLoan_amount(loan.getLoan_amount());
       l1.setUser_id(loan.getUser_id());
       l1.setAccount_id(loan.getAccount_id());
        l1.setLoan_status(loan.getLoan_status());
       l1.setDate_open(loan.getDate_open());
       l1.setTerm(loan.getTerm());
        Loan updloan = loanRepository.save(l1);
        return updloan;
    }

    @DeleteMapping("/loans/{loan_id}")
    public ResponseEntity<?> deleteLoan(@PathVariable(value = "loan_id") int loan_id) throws LoanNotFoundException {
        Loan l2 = loanRepository.findById(loan_id)
                .orElseThrow(() -> new LoanNotFoundException(loan_id));

        loanRepository.delete(l2);
        return ResponseEntity.ok().build();
    }
}

