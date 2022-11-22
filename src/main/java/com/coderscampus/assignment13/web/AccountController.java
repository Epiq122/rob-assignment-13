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

@Controller
public class AccountController {

    private final UserService userService;
    @Autowired
    private AccountService accountService;

    public AccountController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{userId}/accounts/{accountId}")
    public String getAccounts(ModelMap model, @PathVariable Long accountId, @PathVariable String userId) {
        Account account = accountService.findById(accountId);
        User user = account.getUsers().get(0);
        model.put("account", account);
        model.put("user", user);
        return "accounts";
    }

    @PostMapping("/users/{userId}/accounts/{accountId}")
    public String changeAccountType(@PathVariable Long userId, @PathVariable Long accountId, Account account) {
        accountService.saveAccount(account);
        account.setAccountName(account.getAccountName());
        userService.saveUser(userService.findById(userId));
        return "redirect:/users/" + userId + "accounts" + accountId;
    }


    @PostMapping("users/{userId}/accounts")
    public String setSingleAccount(@PathVariable Long userId) {
        accountService.saveAccount(userId);
        return "redirect:/users/" + userId;


    }

}
