package net.sarrthac.banking.service.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.sarrthac.banking.dto.AccountDto;
import net.sarrthac.banking.entity.Account;
import net.sarrthac.banking.mapper.AccountMapper;
import net.sarrthac.banking.repository.AccountRepository;
import net.sarrthac.banking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {

        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);

        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {

        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Account does not Exists"));

        return AccountMapper.mapToAccountDto(account);
    }
}
