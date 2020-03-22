package com.example.demo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;

@Table
@Entity(name="Account")
public class Account {

    @Id
    private int account_id;
    @NotBlank
    private String account_name;
    @NotBlank
    private String account_type;
    @NotBlank
    private String account_address;
    @NotBlank
    private String account_status;
    @NotBlank
    private String email_id;
    @NotBlank
    private String mobile_number;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date_open;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date_closed;

    @NotNull
    private float account_balance;

    public Account(){
        super();
    }
    public Account(int account_id, @NotBlank String account_name, @NotBlank String account_type, @NotBlank String account_address, @NotBlank String account_status,@NotBlank String email_id, @NotBlank String mobile_number, @NotBlank LocalDateTime date_open, @NotBlank LocalDateTime date_closed,@NotNull float account_balance) {
        super();
        this.account_id = account_id;
        this.account_name = account_name;
        this.account_type = account_type;
        this.account_address = account_address;
        this.account_status = account_status;
        this.email_id=email_id;
        this.mobile_number = mobile_number;
        this.date_open = date_open;
        this.date_closed = date_closed;
        this.account_balance=account_balance;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public String getAccount_address() {
        return account_address;
    }

    public void setAccount_address(String account_address) {
        this.account_address = account_address;
    }

    public String getAccount_status() {
        return account_status;
    }

    public void setAccount_status(String account_status) {
        this.account_status = account_status;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public LocalDateTime getDate_open() {
        return date_open;
    }

    public void setDate_open(LocalDateTime date_open) {
        this.date_open = date_open;
    }

    public LocalDateTime getDate_closed() {
        return date_closed;
    }

    public void setDate_closed(LocalDateTime date_closed) {
        this.date_closed = date_closed;
    }

    public float getAccount_balance() {
        return account_balance;
    }

    public void setAccount_balance(float account_balance) {
        this.account_balance = account_balance;
    }

}
