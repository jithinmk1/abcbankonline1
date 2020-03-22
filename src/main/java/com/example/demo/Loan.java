package com.example.demo;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Table
@Entity(name="loan")
public class Loan {
    @Id
    private int loan_id;

    @NotBlank
    private String loan_type;

    @NotNull
    private float loan_amount;

    @NotNull
    private int user_id;

    @NotNull
    private int account_id;
    @NotBlank
    private String loan_status;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date_open;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime term;

    public Loan() {super();
    }
    public Loan(int loan_id,String loan_type,float loan_amount,int user_id,int account_id,String loan_status,LocalDateTime date_open,LocalDateTime term){
       super();
        this.loan_id=loan_id;
        this.loan_type=loan_type;
        this.loan_amount=loan_amount;
        this.user_id=user_id;
        this.account_id=account_id;
        this.loan_status=loan_status;
        this.date_open=date_open;
        this.term=term;
    }
    public int getLoan_id() {
        return loan_id;
    }

    public void setLoan_id(int loan_id) {
        this.loan_id = loan_id;
    }

    public String getLoan_type() {
        return loan_type;
    }

    public void setLoan_type(String loan_type) {
        this.loan_type = loan_type;
    }

    public float getLoan_amount() {
        return loan_amount;
    }

    public void setLoan_amount(float loan_amount) {
        this.loan_amount = loan_amount;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getLoan_status() {
        return loan_status;
    }

    public void setLoan_status(String loan_status) {
        this.loan_status = loan_status;
    }

    public LocalDateTime getDate_open() {
        return date_open;
    }

    public void setDate_open(LocalDateTime date_open) {
        this.date_open = date_open;
    }

    public LocalDateTime getTerm() {
        return term;
    }

    public void setTerm(LocalDateTime term) {
        this.term = term;
    }
}
    /*public Loan(int loan_id,String loan_type,float loan_amount,int user_id,int account_id,String loan_status,LocalDateTime date_open,LocalDateTime term){
        super();
        this.loan_id=loan_id;
        this.loan_type=loan_type;
        this.loan_amount=loan_amount;
        this.user_id=user_id;
        this.account_id=account_id;
        this.loan_status=loan_status;
        this.date_open=date_open;
        this.term=term;*/
