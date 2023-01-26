package com.javastart.hellospring.controller;

import com.javastart.hellospring.controller.dto.AccountRequestDto;
import com.javastart.hellospring.repository.AccountRepository;
import com.javastart.hellospring.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class AccountController {


    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/hello")
    public String helloSpring() {
        return "Hello Spring";
    }

    @PostMapping("/accounts")
    public Long createAccount(@RequestBody AccountRequestDto accountRequestDto) {
        return accountService.createAccount(accountRequestDto.getName(), accountRequestDto.getEmail(), Integer.valueOf(accountRequestDto.getBill()));
    }
}
