package com.maximdenishev.spring.mvc.repository;

import com.maximdenishev.spring.mvc.entity.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

}
