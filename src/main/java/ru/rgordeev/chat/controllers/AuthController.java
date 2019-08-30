package ru.rgordeev.chat.controllers;

import ru.rgordeev.chat.data.UserData;
import ru.rgordeev.chat.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String login() {
        return "index.html";
    }

    @PostMapping
    @ResponseBody
    public UserData getToken(@RequestBody String login) {
        return userService.requestToken(login);
    }
}


