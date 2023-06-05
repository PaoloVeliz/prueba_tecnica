package com.example.springboottest.service;


import com.example.springboottest.entity.User;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.JSONPObject;

import java.util.List;
import java.util.Map;

public interface UserService {

    // Save operation
    Map<String, String> saveUser(User user);


    // Update operation
    Map<String, String> deleteUser(Long userId);
}
