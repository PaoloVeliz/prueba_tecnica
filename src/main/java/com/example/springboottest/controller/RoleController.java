package com.example.springboottest.controller;


import com.example.springboottest.entity.Role;
import com.example.springboottest.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RoleController {
    @Autowired private RoleService roleService;

    @PostMapping("/roles")
    public Map<String, Object> saveRole(@RequestBody Role role) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("response", "ok");
        map.put("role", roleService.saveRole(role));
        return map;
    }

}
