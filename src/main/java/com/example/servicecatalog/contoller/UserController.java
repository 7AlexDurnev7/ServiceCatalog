package com.example.servicecatalog.contoller;

import com.example.servicecatalog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    // контроллер для тестирования пользователей
    @Autowired
    private UserService userService;
//    @PostMapping("/users/new")
//    public String addUser(@RequestParam String username, @RequestParam String password) {
//        userService.addUser(username, password);
//        return "user added";
//    }
}
