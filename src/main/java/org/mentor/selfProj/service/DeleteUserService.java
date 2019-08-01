package org.mentor.selfProj.service;

import org.mentor.selfProj.config.DBConfig;
import org.mentor.selfProj.dao.Dao;
import org.mentor.selfProj.dao.UserDao;

import java.sql.Connection;
import java.sql.SQLException;

public class DeleteUserService {

  Connection connection = DBConfig.getMysqlConnection();


        public int deleteUser(String id) throws Exception {
        try {
            connection.setAutoCommit(false);
            UserDao userDao = new Dao(connection);
            userDao.deleteUser(id);
            connection.commit();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

}
