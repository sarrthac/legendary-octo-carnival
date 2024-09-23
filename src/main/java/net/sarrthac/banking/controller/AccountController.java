package net.sarrthac.banking.controller;

import net.sarrthac.banking.dto.AccountDto;
import net.sarrthac.banking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto)
    {
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAllAccounts(@PathVariable Long id)
    {
       AccountDto accountDto = accountService.getAccountById(id);
       return ResponseEntity.ok(accountDto);
    }
}
