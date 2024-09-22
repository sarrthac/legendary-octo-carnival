package net.sarrthac.banking.service.impl;

import net.sarrthac.banking.dto.AccountDto;
import net.sarrthac.banking.entity.Account;
import net.sarrthac.banking.mapper.AccountMapper;
import net.sarrthac.banking.repository.AccountRepository;
import net.sarrthac.banking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public AccountDto createAccount(AccountDto accountDto) {

        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);

        return AccountMapper.mapToAccountDto(savedAccount);
    }
}
