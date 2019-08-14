package org.mentor.selfproj.dao;

import org.mentor.selfproj.model.User;

import java.util.List;

public interface UserDao {
    void createUser(User user);

    void deleteUser(String id);

    void updateUser(User user);

    List<User> selectData() ; //List<User>

    User selectDataById(String id);
}
