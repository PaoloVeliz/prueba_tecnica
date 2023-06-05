package com.example.springboottest.service;


import com.example.springboottest.entity.Role;
import com.example.springboottest.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleRepository roleRepository;

    // save operation
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

}
