package com.maximdenishev.spring.mvc.controller;

import com.maximdenishev.spring.mvc.dto.AccountRequestDTO;
import com.maximdenishev.spring.mvc.dto.AccountResponseDTO;
import com.maximdenishev.spring.mvc.entity.Account;
import com.maximdenishev.spring.mvc.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AccountComtroller {
    private final AccountService accountService;

    @Autowired
    public AccountComtroller(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{od}")
    public AccountResponseDTO getAccount(@PathVariable Long id) {
        return new AccountResponseDTO(accountService.getAccountById(id));
    }

    @PostMapping("/")
    public Long createAccount(@RequestBody AccountRequestDTO accountRequestDTO) {
        return accountService.createAccount(accountRequestDTO.getName(), accountRequestDTO.getPhone(), accountRequestDTO.getEmail(), accountRequestDTO.getBills());
    }

    @PutMapping("/{id}")
    public AccountResponseDTO updateAccount(@PathVariable Long id, @RequestBody AccountRequestDTO accountRequestDTO){
        return new AccountResponseDTO(accountService.updateAccount(id, accountRequestDTO.getName(), accountRequestDTO.getPhone(), accountRequestDTO.getEmail(), accountRequestDTO.getBills()));
    }

    @DeleteMapping("/{id}")
    public AccountResponseDTO deleteAccount(@PathVariable Long id){
        return new AccountResponseDTO(accountService.deleteAccountById(id));

    }
}
