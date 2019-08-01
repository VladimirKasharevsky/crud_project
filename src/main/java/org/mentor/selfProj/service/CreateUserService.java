package org.mentor.selfProj.service;

import org.mentor.selfProj.config.DBConfig;
import org.mentor.selfProj.dao.Dao;
import org.mentor.selfProj.dao.UserDao;
import org.mentor.selfProj.model.User;

import java.sql.Connection;
import java.sql.SQLException;

public class CreateUserService {

  Connection connection = DBConfig.getMysqlConnection();


    public int addUser(User user) throws Exception {
        try {
            connection.setAutoCommit(false);
            UserDao userDao = new Dao(connection);
            userDao.addUser(user);
            connection.commit();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

}
