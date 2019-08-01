package org.mentor.selfProj.dao;

import org.mentor.selfProj.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface UserDao {
    void insertUserPrep(User user) throws SQLException; //add

    void dellUserPrep(String id) throws SQLException;

    void updateUserPrep(User user, String id) throws SQLException;

    ResultSet selectData() throws SQLException;
}
