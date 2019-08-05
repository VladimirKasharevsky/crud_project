package org.mentor.selfProj.service;

import org.mentor.selfProj.config.DBConfig;
import org.mentor.selfProj.dao.Dao;
import org.mentor.selfProj.dao.UserDao;
import org.mentor.selfProj.model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserServiceClass implements UserService {

    Connection connection = DBConfig.getMysqlConnection();

    @Override
    public void createUser(User user) {
        try {
            connection.setAutoCommit(false);
            UserDao userDao = new Dao(connection);
            userDao.addUser(user);
            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    @Override
    public void deleteUser() {

    }

    @Override
    public List listData() {
        return null;
    }

    @Override
    public void updateUser() {

    }
}
