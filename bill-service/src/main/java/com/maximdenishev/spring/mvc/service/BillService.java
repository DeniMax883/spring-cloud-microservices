package com.maximdenishev.spring.mvc.service;


import com.maximdenishev.spring.mvc.entity.Bill;
import com.maximdenishev.spring.mvc.exception.BillNotFoundException;
import com.maximdenishev.spring.mvc.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service
public class BillService {

    private final BillRepository billRepository;

    @Autowired
    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public Bill getBillById(Long id) {
        return billRepository.findById(id).orElseThrow(() -> new BillNotFoundException("Unable to find bill with id" + id));
    }

    public Long createBill(Long accountId, BigDecimal amount, Boolean isDefault, Boolean overdraftEnabled) {
        Bill bill = new Bill(accountId, amount, isDefault, OffsetDateTime.now(), overdraftEnabled);
        return billRepository.save(bill).getId();
    }

    public Bill updateBill(Long id, Long accountId, BigDecimal amount, Boolean isDefault, Boolean overdraftEnabled) {
        Bill bill = new Bill(accountId, amount, isDefault, overdraftEnabled);
        bill.setId(id);
        return billRepository.save(bill);
    }

    public Bill deleteBillById(Long id) {
        Bill deleteBill = getBillById(id);
        billRepository.delete(deleteBill);
        return deleteBill;
    }
}
