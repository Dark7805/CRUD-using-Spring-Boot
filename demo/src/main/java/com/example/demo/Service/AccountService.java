package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Account;

public interface AccountService {
    public Account createAccount(Account account);

    public Account getAccountDetailsByAcNum(Long ac_number);

    public List<Account>  getAllAccount();
    public Account depositAmount(Long ac_number,Double balance);
    public Account withdraw(Long ac_number,Double balance);

}
