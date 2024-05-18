package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Entity.Account;
import com.example.demo.Repository.AccountRepo;

@Service
public class AccountServiceImpl implements AccountService {


      @Autowired
      AccountRepo repo;
    @Override
    public Account createAccount(Account account) {
        Account ac = repo.save(account);;
        return ac;
    }
    @Override
    public Account getAccountDetailsByAcNum(Long ac_number) {
        Optional<Account> ac= repo.findById(ac_number);
        if(ac.isEmpty()){
            throw new RuntimeException("Account does not exist");
        }
        Account account=ac.get();
        return account;
    }
    @Override
    public List<Account> getAllAccount() {
       List<Account> ac=repo.findAll();
       return ac;
    }
    @Override
    public Account depositAmount(Long ac_number, Double balance) {
        Optional<Account> ac=repo.findById(ac_number);
        if(ac.isEmpty()){
            throw new RuntimeException("Account does not found");
        }
        Account account=ac.get();
       Double finalBalance =account.getBalance()+balance;
        account.setBalance(finalBalance);
        repo.save(account);
      return account;
    }
    @Override
    public Account withdraw(Long ac_number, Double balance) {
       Optional<Account> ac=repo.findById(ac_number);
       if(ac.isEmpty()){
        throw new RuntimeException("Account does not exist");
       }
       Account account=ac.get();
       Double finalBalance= account.getBalance()-balance;
       account.setBalance(finalBalance);
       repo.save(account);
       return account;
    }
    
}
