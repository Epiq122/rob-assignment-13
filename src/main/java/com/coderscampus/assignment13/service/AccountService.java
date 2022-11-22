package com.coderscampus.assignment13.service;

import com.coderscampus.assignment13.domain.Account;
import com.coderscampus.assignment13.domain.User;
import com.coderscampus.assignment13.repository.AccountRepository;
import com.coderscampus.assignment13.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    UserRepository userRepo;
    @Autowired
    UserService userService;
    @Autowired
    private AccountRepository accountRepo;


    public Account saveAccount(Long userId) {
        Account account = new Account();
        User user = userService.findById(userId);
        user.getAccounts().add(account);
        account.getUsers().add(user);
        account.setAccountName("Account " + user.getAccounts().size());

        return accountRepo.save(account);
    }

    public void saveAccount(Account account) {
        accountRepo.save(account);
    }

    public Account findById(Long accountId) {
        return accountRepo.findById(accountId).orElse(new Account());
    }
}
