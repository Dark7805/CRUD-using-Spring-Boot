package com.example.demo.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "account2")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ac_number;

    private String holder_name;
    private Double balance;
    public Long getAc_number() {
        return ac_number;
    }
    public void setAc_number(Long ac_number) {
        this.ac_number = ac_number;
    }
    public String getHolder_name() {
        return holder_name;
    }
    public void setHolder_name(String holder_name) {
        this.holder_name = holder_name;
    }
    public Account( String holder_name, Double balance) {
        
        this.holder_name = holder_name;
        this.balance = balance;
    }
    public Double getBalance() {
        return balance;
    }
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Account(){

    }
    @Override
    public String toString() {
        return "Account [ac_number=" + ac_number + ", holder_name=" + holder_name + ", balance=" + balance + "]";
    }
    
}
