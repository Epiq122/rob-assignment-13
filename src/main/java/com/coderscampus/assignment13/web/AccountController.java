package com.coderscampus.assignment13.web;

import com.coderscampus.assignment13.domain.Account;
import com.coderscampus.assignment13.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    // create get mapping for accounts
    @GetMapping("/accounts")
    public String getAccounts(ModelMap model) {
        model.put("accounts", new Account());
        return "accounts";
    }

    // create post mapping for accounts
    @PostMapping("/accounts")
    public String postAccounts(Account account) {
        accountService.save(account);
        return "redirect:/accounts";
    }

}
