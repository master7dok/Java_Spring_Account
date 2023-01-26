package com.javastart.hellospring.repository;

import com.javastart.hellospring.controller.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
