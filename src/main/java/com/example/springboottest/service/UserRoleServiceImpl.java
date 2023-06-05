package com.example.springboottest.service;

import com.example.springboottest.entity.User;
import com.example.springboottest.entity.UserRole;
import com.example.springboottest.repository.RoleRepository;
import com.example.springboottest.repository.UserRepository;
import com.example.springboottest.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class UserRoleServiceImpl implements  UserRoleService {
    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public String saveUserRole(Map<String, Object> userRole) {
        boolean does_role_exist = roleRepository.existsById(Long.parseLong(((LinkedHashMap) userRole.get("role") ).get("id").toString()));
        boolean does_user_exist = userRepository.existsById(Long.parseLong(((LinkedHashMap) userRole.get("user") ).get("id").toString()));
        if (does_user_exist) {
            User is_user_habilitated = userRepository.findById(Long.parseLong(((LinkedHashMap) userRole.get("user") ).get("id").toString())).get();
            if (is_user_habilitated.getStatus() != 2) {
                if (does_role_exist) {
                    UserRole new_user_role = new UserRole();
                    new_user_role.setUser_id(Integer.parseInt(((LinkedHashMap) userRole.get("user") ).get("id").toString()));
                    new_user_role.setRole_id(Integer.parseInt(((LinkedHashMap) userRole.get("role") ).get("id").toString()));
                    userRoleRepository.save(new_user_role);
                    return "ok";
                }else {
                 return "role does not exist";
                }
            } else {
                return "user is not enable";
            }
        }else {
            return "user does not exist";
        }


    }
}
