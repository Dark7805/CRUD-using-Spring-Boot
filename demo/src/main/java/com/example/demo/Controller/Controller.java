package com.example.demo.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Account;
import com.example.demo.Service.AccountServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("account")
public class Controller {
    
  @Autowired
  AccountServiceImpl acimpl;
    @GetMapping("index")
    public String hello() {
        return "welcome";
    }
    

    @PostMapping("create")
    public ResponseEntity<Account> create(@RequestBody Account account){
        Account ac=acimpl.createAccount(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(ac);
    }

    @GetMapping("{ac_number}")
    public Account getAccountByAccNum(@PathVariable Long ac_number){
       Account ac= acimpl.getAccountDetailsByAcNum(ac_number);
        return ac;
    }


    @GetMapping("getAllAccounts")
    public List<Account> getAllAccount(){
      
        List<Account> ac= acimpl.getAllAccount();
        return ac;
    }


    @PutMapping("/deposit/{ac_number}/{balance}")
    public Account depositAmount(@PathVariable Long ac_number, @PathVariable Double balance){
        Account ac= acimpl.depositAmount(ac_number, balance);
        return ac;
    }

    @PutMapping("/withdraw/{ac_number}/{balance}")
    public Account withdraw(@PathVariable Long ac_number, @PathVariable Double balance){
       Account ac=acimpl.withdraw(ac_number, balance);
       return ac;
    }
    
    
}
