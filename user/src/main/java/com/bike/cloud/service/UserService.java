package com.bike.cloud.service;

import com.bike.cloud.entities.User;


public interface UserService {

    void addUser(User user);

    User getUserById(Integer id);


    User getUserByName(String username);

    void updateAvatar(Integer id, String url);

    void updatePwd(Integer id, String password);
}
