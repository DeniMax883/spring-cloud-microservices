package com.maximdenishev.spring.mvc.repository;

import com.maximdenishev.spring.mvc.entity.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {

}
