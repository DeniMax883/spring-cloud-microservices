package com.maximdenishev.spring.mvc.service;

import com.maximdenishev.spring.mvc.entity.Account;
import com.maximdenishev.spring.mvc.exception.AccountNotFoundException;
import com.maximdenishev.spring.mvc.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;


@Service
public class AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account getAccountById(Long id){
       return accountRepository.findById(id).orElseThrow(()-> new AccountNotFoundException("Unable to find account with id"+ id));
    }

    public Long createAccount(String name, String phone, String email, List<Long>bills){
        Account account = new Account(name, phone, email, OffsetDateTime.now(), bills);
        return accountRepository.save(account).getId();
    }

    public Account updateAccount(Long id, String name, String phone, String email, List<Long>bills){
        Account account = new Account();
        account.setId(id);
        account.setName(name);
        account.setPhone(phone);
        account.setEmail(email);
        account.setBills(bills);
        return accountRepository.save(account);
    }

    public Account deleteAccountById (Long id){
        Account deleteAccount = getAccountById(id);
        accountRepository.delete(deleteAccount);
        return deleteAccount;

    }

}
