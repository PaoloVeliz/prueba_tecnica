package com.example.springboottest.controller;

import com.example.springboottest.entity.User;
import com.example.springboottest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

@RestController
public class UserController {
    @Autowired private UserService userService;

    @PostMapping("/users")
    public Map<String, Object> saveUser(@RequestBody User user) {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("response", "ok");
        map.put("user", userService.saveUser(user));
        return map;
    }


    @DeleteMapping("/users/{id}")
    public Map<String, String> deleteUser(@PathVariable("id") Long userId){
        return userService.deleteUser(userId);
    }
}
