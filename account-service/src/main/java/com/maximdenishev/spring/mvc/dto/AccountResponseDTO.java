package com.maximdenishev.spring.mvc.dto;


import com.maximdenishev.spring.mvc.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.OffsetDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class AccountResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private OffsetDateTime creationDate;
    private List<Long> bills;

    public AccountResponseDTO(Account account){
        id = account.getId();
        name = account.getName();
        email = account.getEmail();
        phone = account.getPhone();
        creationDate = account.getCreationDate();
        bills = account.getBills();
    }
}
