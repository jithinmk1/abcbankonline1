package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Table
@Entity(name="bill_payee")
public class BillPayee {

    @Id
    private int payee_id;

    @NotNull
    private int user_id;
    @NotBlank
    private String payee_address;

    @NotNull
    private int account_no;
    @NotNull
    private int payee_account_no;
    @NotBlank
    private String payee_phone;

    public BillPayee() {
        super();
    }

    public BillPayee(int payee_id, int user_id, int account_no,int payee_account_no,String payee_address, String payee_phone) {
        super();
        this.payee_id=payee_id;
        this.user_id=user_id;
        this.account_no=account_no;
        this.payee_address=payee_address;
        this.payee_phone=payee_phone;
        this.payee_account_no=payee_account_no;


    }

    public int getPayee_id() {
        return payee_id;
    }

    public void setPayee_id(int payee_id) {
        this.payee_id = payee_id;
    }

    public String getPayee_address() {
        return payee_address;
    }

    public void setPayee_address(String payee_address) {
        this.payee_address = payee_address;
    }

    public int getPayee_account_no() {
        return payee_account_no;
    }

    public void setPayee_account_no(int payee_account_no) {
        this.payee_account_no = payee_account_no;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getAccount_no() {
        return account_no;
    }

    public void setAccount_no(int account_no) {
        this.account_no = account_no;
    }

    public String getPayee_phone() {
        return payee_phone;
    }

    public void setPayee_phone(String payee_phone) {
        this.payee_phone = payee_phone;
    }
}

