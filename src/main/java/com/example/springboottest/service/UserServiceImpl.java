package com.example.springboottest.service;


import at.favre.lib.crypto.bcrypt.BCrypt;
import com.example.springboottest.entity.User;
import com.example.springboottest.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    // Save operation
    public Map<String, String> saveUser(User user) {
        user.setStatus(1);
        user.setPassword(BCrypt.withDefaults().hashToString(12, user.getPassword().toCharArray()));
        User saved_user = userRepository.save(user);
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("id", String.valueOf(saved_user.getId()));
        map.put("name", saved_user.getName());
        map.put("username", saved_user.getUsername());
        map.put("status", String.valueOf(saved_user.getStatus()));
        return map;
    }

    public Map<String, String> deleteUser(Long userId) {
        User ser_to_update = userRepository.findById(userId).get();
        ser_to_update.setStatus(2);
        userRepository.save(ser_to_update);
        HashMap<String, String> map = new HashMap<>();
        map.put("response", "ok");
        return map;
    }
}
