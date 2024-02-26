package com.maximdenishev.spring.mvc.controller;

import com.maximdenishev.spring.mvc.dto.BillRequestDTO;
import com.maximdenishev.spring.mvc.dto.BillResponseDTO;
import com.maximdenishev.spring.mvc.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillController {

    private final BillService billService;

    @Autowired
    public BillController(BillService billService) {
        this.billService = billService;
    }

    @GetMapping("/{id}")
    public BillResponseDTO getBill(@PathVariable Long id) {
        return new BillResponseDTO(billService.getBillById(id));
    }

    @PostMapping("/")
    public Long createBill(@RequestBody BillRequestDTO billRequestDTO) {
        return billService.createBill(billRequestDTO.getAccountId(), billRequestDTO.getAmount(),
                billRequestDTO.getIsDefault(), billRequestDTO.getOverdraftEnabled());
    }

    @PutMapping("/{id}")
    public BillResponseDTO updateAccount(@PathVariable Long id, @RequestBody BillRequestDTO billRequestDTO){
        return new BillResponseDTO(billService.updateBill(id, billRequestDTO.getAccountId(), billRequestDTO.getAmount(),
                billRequestDTO.getIsDefault(), billRequestDTO.getOverdraftEnabled()));
    }

    @DeleteMapping("/{id}")
    public BillResponseDTO deleteBill (@PathVariable Long id){
        return new BillResponseDTO(billService.deleteBillById(id));
    }

}
