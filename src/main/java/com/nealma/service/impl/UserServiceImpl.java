package com.nealma.service.impl;

import com.nealma.dao.UserDao;
import com.nealma.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by nealpc on 7/4/16.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void create(String name, Integer age) {
        userDao.create(name, age);
    }

    @Override
    public void deleteByName(String name) {
        userDao.deleteByName(name);
    }

    @Override
    public Integer getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void deleteAllUsers() {
        userDao.deleteAllUsers();
    }
}
