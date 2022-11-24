package com.coderscampus.assignment13.web;

import com.coderscampus.assignment13.domain.Account;
import com.coderscampus.assignment13.domain.User;
import com.coderscampus.assignment13.service.AccountService;
import com.coderscampus.assignment13.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/users/{userId}/accounts")
@Controller

public class AccountController {

    @Autowired
    private UserService userService;
    @Autowired
    private AccountService accountService;


    @GetMapping("{accountId}")
    public String getAccounts(ModelMap model, @PathVariable Long accountId, @PathVariable Long userId, User user, Account account) {
        accountService.findById(accountId);
        userService.findById(userId);
        model.put("account", account);
        model.put("user", user);
        return "account";
    }

    @PostMapping("")
    public String changeAccountType(@PathVariable Long userId, Account account, User user) {
        userService.findById(userId);
        account.setAccountName("Account " + user.getAccounts().size());
        account.getUsers().add(user);
        user.getAccounts().add(account);
        accountService.saveAccount(account);
        return "redirect:/users/" + userId + "/accounts/" + account.getAccountId();
    }


    @PostMapping("{accountId}")
    public String postSingleAccount(@PathVariable Long userId, Account account) {
        accountService.saveAccount(account);
        return "redirect:/users/" + userId + "/accounts/" + account.getAccountId();


    }

}
