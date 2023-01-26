package com.javastart.hellospring.controller;

import com.javastart.hellospring.controller.dto.AccountRequestDto;
import com.javastart.hellospring.controller.dto.AccountResponseDto;
import com.javastart.hellospring.controller.entity.Account;
import com.javastart.hellospring.repository.AccountRepository;
import com.javastart.hellospring.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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
        return accountService.createAccount(accountRequestDto.getName(), accountRequestDto.getEmail(), accountRequestDto.getBill());
    }

    @GetMapping("/accounts/{id}")
    public AccountResponseDto getAccount(@PathVariable Long id) {
        return new AccountResponseDto((accountService.getAccountById(id)));

    }
@GetMapping("/accounts")
    public List<AccountResponseDto> getAll(){
        return accountService.getAll().stream().map(AccountResponseDto::new)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/accounts/{id}")
    public AccountResponseDto delete(@PathVariable Long id) {
        return new AccountResponseDto(accountService.deleteById(id));
    }
}
