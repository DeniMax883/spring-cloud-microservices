package com.maximdenishev.spring.mvc.dto;

import com.maximdenishev.spring.mvc.entity.Bill;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@AllArgsConstructor
public class BillResponseDTO {

    private Long id;
    private Long accountId;
    private BigDecimal amount;
    private Boolean isDefault;
    private OffsetDateTime creationDate;
    private Boolean overdraftEnabled;

    public BillResponseDTO(Bill bill) {
        id = bill.getId();
        accountId = bill.getAccountId();
        amount = bill.getAmount();
        isDefault = bill.getIsDefault();
        creationDate = bill.getCreationDate();
        overdraftEnabled = bill.getOverdraftEnabled();
    }
}
