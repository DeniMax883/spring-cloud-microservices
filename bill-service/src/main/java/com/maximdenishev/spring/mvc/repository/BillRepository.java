package com.maximdenishev.spring.mvc.repository;

import com.maximdenishev.spring.mvc.entity.Bill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface BillRepository extends CrudRepository<Bill, Long> {

}
