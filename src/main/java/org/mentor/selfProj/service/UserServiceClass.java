package org.mentor.selfProj.service;

import org.mentor.selfProj.config.DBConfig;
import org.mentor.selfProj.dao.Dao;
import org.mentor.selfProj.model.User;

import java.sql.Connection;
import java.util.List;

public class UserServiceClass implements UserService {

    Connection connection = DBConfig.getMysqlConnection();
    Dao userDao = new Dao(connection);

    @Override
    public void createUser(User user) {
        userDao.createUser(user);
    }

    @Override
    public void deleteUser(String id) {
        userDao.deleteUser(id);
    }

    @Override
    public List listData() {
        return userDao.selectData();
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public User getUserById(String id) {
        return userDao.selectDataById(id);
    }
}
