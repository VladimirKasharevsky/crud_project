package org.mentor.selfProj.service;

import org.mentor.selfProj.config.DBConfig;
import org.mentor.selfProj.dao.Dao;
import org.mentor.selfProj.dao.UserDao;
import org.mentor.selfProj.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SelectDataByIdService {

    Connection connection = DBConfig.getMysqlConnection();

    private List<User> list = new ArrayList<>();

    public List listData() {
        try {
            connection.setAutoCommit(false);
            UserDao userDao = new Dao(connection);
            ResultSet rs = userDao.selectData();
            connection.commit();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                list.add(user);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
