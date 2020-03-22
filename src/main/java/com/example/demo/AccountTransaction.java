package com.example.demo;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Table
@Entity(name="Account_transaction")
public class AccountTransaction {

    @Id
    private int account_id;
    @NotBlank
    private String transaction_no;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime transaction_date;
    @NotNull
    private float transaction_amount;
    @NotBlank
    private String transaction_type;
    @NotNull
    private int loan_id;
    @NotNull
    private int payee_id;

    public AccountTransaction() {
        super();
    }

    public AccountTransaction(int account_id, String transaction_no, LocalDateTime transaction_date, float transaction_amount, String transaction_type, int loan_id, int payee_id) {
        super();
        this.account_id = account_id;
        this.transaction_no = transaction_no;
        this.transaction_date = transaction_date;
        this.transaction_amount = transaction_amount;
        this.transaction_type = transaction_type;
        this.loan_id = loan_id;
        this.payee_id = payee_id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getTransaction_no() {
        return transaction_no;
    }

    public void setTransaction_no(String transaction_no) {
        this.transaction_no = transaction_no;
    }

    public LocalDateTime getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(LocalDateTime transaction_date) {
        this.transaction_date = transaction_date;
    }

    public float getTransaction_amount() {
        return transaction_amount;
    }

    public void setTransaction_amount(float transaction_amount) {
        this.transaction_amount = transaction_amount;
    }

    public String getTransaction_type() {
        return transaction_type;
    }

    public void setTransaction_type(String transaction_type) {
        this.transaction_type = transaction_type;
    }

    public int getLoan_id() {
        return loan_id;
    }

    public void setLoan_id(int loan_id) {
        this.loan_id = loan_id;
    }

    public int getPayee_id() {
        return payee_id;
    }

    public void setPayee_id(int payee_id) {
        this.payee_id = payee_id;
    }

}
