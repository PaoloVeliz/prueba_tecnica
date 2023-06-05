package com.example.springboottest.controller;


import com.example.springboottest.entity.UserRole;
import com.example.springboottest.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class UserRoleController {
    @Autowired private UserRoleService userRoleService;

    @PostMapping("/addRole")
    public Map<String, Object> saveUserRole(@RequestBody Map<String, Object> request) {
        //return ((LinkedHashMap) request.get("user") ).get("id");

        HashMap<String, Object> map = new HashMap<>();
        map.put("response", userRoleService.saveUserRole(request));
        return map;
    }
}
