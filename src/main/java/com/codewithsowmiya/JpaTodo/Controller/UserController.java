package com.codewithsowmiya.JpaTodo.Controller;

import com.codewithsowmiya.JpaTodo.Model.User;
import com.codewithsowmiya.JpaTodo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    private User doLogin(@RequestBody User user) {
        return userService.login(user);
    }

    @PostMapping("/register")
    private User doRegister(@RequestBody User user) {
        return userService.register(user);
    }


}
