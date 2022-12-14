package com.coderscampus.assignment13.web;


//}
//@Controller
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/register")
//    public String getCreateUser(ModelMap model) {
//
//        model.put("user", new User());
//
//        return "register";
//    }
//
//    @PostMapping("/register")
//    public String postCreateUser(User user) {
//        System.out.println(user);
//        userService.save(user);
//        return "redirect:/register";
//    }
//
//    @GetMapping("/users")
//    public String getAllUsers(ModelMap model) {
//        Set<User> users = userService.findAll();
//
//        model.put("users", users);
//        if (users.size() == 1) {
//            model.put("user", users.iterator().next());
//        }
//
//        return "users";
//    }
//
//    @GetMapping("/users/{userId}")
//    public String getOneUser(ModelMap model, @PathVariable Long userId) {
//        User user = userService.findById(userId);
//        model.put("users", Collections.singletonList(user));
//        model.put("user", user);
//        return "users";
//    }
//
//    @PostMapping("/users/{userId}")
//    public String postSingleUser(User user) {
//        userService.save(user);
//        return "redirect:/users/" + user.getUserId();
//    }
//
//    @PostMapping("/users/{userId}/delete")
//    public String deleteOneUser(@PathVariable Long userId) {
//        userService.delete(userId);
//        return "redirect:/users";
//    }
//}


import com.coderscampus.assignment13.domain.User;
import com.coderscampus.assignment13.service.AddressService;
import com.coderscampus.assignment13.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Set;

@Controller
@CrossOrigin("http://localhost:8080")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private AddressService addressService;

    @GetMapping("/register")
    public String getCreateUser(ModelMap model) {

        model.put("user", new User());

        return "register";
    }

    @PostMapping("/register")
    public String postCreateUser(User user) {
        System.out.println(user);
        userService.save(user);
        return "redirect:/register";
    }

    @GetMapping("/users")
    public String getAllUsers(ModelMap model) {
        Set<User> users = userService.findAll();

        model.put("users", users);
        if (users.size() == 1) {
            model.put("user", users.iterator().next());
        }

        return "users";
    }

    @GetMapping("/users/{userId}")
    public String getOneUser(ModelMap model, @PathVariable Long userId) {
        User user = userService.findById(userId);
        model.put("users", Collections.singletonList(user));
        model.put("user", user);
        return "users";
    }


    @PostMapping("/users/{userId}")
    public String postOneUser(User user) {
        userService.save(user);
        return "redirect:/users/" + user.getUserId();
    }

    @PostMapping("/users/{userId}/delete")
    public String deleteOneUser(@PathVariable Long userId) {
        userService.delete(userId);
        return "redirect:/users";
    }
}