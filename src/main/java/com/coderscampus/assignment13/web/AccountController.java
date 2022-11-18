package com.coderscampus.assignment13.web;

import com.coderscampus.assignment13.service.AccountService;
import com.coderscampus.assignment13.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;
    private UserService userService;

    @GetMapping("/users/{userId}/accounts/{accountId}")
    public String getAccounts(@PathVariable Long accountId, @PathVariable String userId) {
        return "redirect:/users/";

    }

    // Create Post for account
    @PostMapping("/users/{userId}/accounts/{accountId}")
    public String postAccounts(@PathVariable Long accountId, @PathVariable String userId) {
        return "redirect:/users/";

    }

}
