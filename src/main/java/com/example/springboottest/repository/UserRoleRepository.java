package com.example.springboottest.repository;

import com.example.springboottest.entity.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository  extends CrudRepository<UserRole, Long> {
}
