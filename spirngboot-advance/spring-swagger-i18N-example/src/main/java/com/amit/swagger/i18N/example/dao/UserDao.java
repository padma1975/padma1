package com.amit.swagger.i18N.example.dao;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amit.swagger.i18N.example.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
}
