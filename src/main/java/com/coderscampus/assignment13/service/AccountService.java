package com.coderscampus.assignment13.service;

import com.coderscampus.assignment13.domain.Account;
import com.coderscampus.assignment13.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {


    @Autowired
    private AccountRepository accountRepo;


    public Account saveAccount(Account account) {
        return accountRepo.save(account);
    }

    public void deleteAccount(Long accountId) {
        accountRepo.deleteById(accountId);
    }

    public Account findById(Long accountId) {
        return accountRepo.findById(accountId).orElse(new Account());
    }
}
