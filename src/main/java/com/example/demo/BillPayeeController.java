package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class BillPayeeController {
    final
    @Autowired
    BillPayeeRepository billPayeeRepository;

    public BillPayeeController(BillPayeeRepository billPayeeRepository) {
        this.billPayeeRepository = billPayeeRepository;
    }

    @GetMapping("/bill_payees")
    public List<BillPayee> getAllBillPayee() {
        return billPayeeRepository.findAll();
    }

    @GetMapping("/bill_payees/{payee_id}")
    public Optional<BillPayee> getAllBillPayeeById(@PathVariable(value = "payee_id") Integer payee_id) {
        return billPayeeRepository.findById(payee_id);
    }

    @PostMapping("/bill_payees")
    public @Valid BillPayee CreateBillPayee(@Valid @RequestBody BillPayee billPayee) {
        return billPayeeRepository.save(billPayee);
    }


    @PutMapping("/bill_payees/{payee_id}")
    public @Valid BillPayee updateBillPayeeById(@PathVariable(value = "payee_id") Integer payee_Id, @Valid @RequestBody BillPayee billpayee) throws BillPayeeNotFoundException {
        BillPayee b1 = billPayeeRepository.findById(payee_Id).orElseThrow(() -> new BillPayeeNotFoundException(payee_Id));
        b1.setUser_id(billpayee.getUser_id());
        b1.setAccount_no(billpayee.getAccount_no());
        b1.setPayee_address(billpayee.getPayee_address());
        b1.setPayee_account_no(billpayee.getPayee_account_no());
        b1.setPayee_phone(billpayee.getPayee_phone());
        BillPayee updpayee = billPayeeRepository.save(b1);
        return updpayee;

    }

    @DeleteMapping("/bill_payees/{payee_id}")
    public ResponseEntity<?> deleteBillPayee(@PathVariable(value = "payee_id") int payee_Id) throws BillPayeeNotFoundException {
        BillPayee b2 =billPayeeRepository.findById(payee_Id)
                .orElseThrow(() -> new BillPayeeNotFoundException(payee_Id));
        billPayeeRepository.delete(b2);
        return ResponseEntity.ok().build();
    }
}

