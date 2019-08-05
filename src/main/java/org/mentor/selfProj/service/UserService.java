package org.mentor.selfProj.service;

import org.mentor.selfProj.model.User;

import java.util.List;

public interface UserService {
    void createUser(User user) ;

    void deleteUser();

    List listData();

    void updateUser();
}
