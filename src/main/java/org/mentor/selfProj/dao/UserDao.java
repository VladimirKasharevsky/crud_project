package org.mentor.selfProj.dao;

import org.mentor.selfProj.model.User;

import java.sql.ResultSet;

public interface UserDao {
    void addUser(User user);

    void deleteUser(String id);

    void updateUser(User user, String id);

    ResultSet selectData() ;

    ResultSet selectDataById(User user);
}
