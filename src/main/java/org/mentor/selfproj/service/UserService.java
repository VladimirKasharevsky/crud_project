package org.mentor.selfproj.service;

import org.mentor.selfproj.model.User;

import java.util.List;

public interface UserService {
    void createUser(User user) ;

    void deleteUser(String id);

    List listData();

    void updateUser(User user);

    User getUserById(String id);
}
