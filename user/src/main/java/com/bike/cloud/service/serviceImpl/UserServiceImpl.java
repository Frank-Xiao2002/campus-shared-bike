package com.bike.cloud.service.serviceImpl;

import com.bike.cloud.mapper.UserMapper;
import com.bike.cloud.entities.User;
import com.bike.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(User user) {
        userMapper.add(user);
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.findByUserId(id);
    }

    @Override
    public User getUserByName(String username) {
        return userMapper.findByUserName(username);
    }

    @Override
    public void updateAvatar(Integer id, String url) {
        userMapper.updateAvatar(url,id);
    }

    @Override
    public void updatePwd(Integer id, String password) {
        userMapper.updatePwd(password,id);
    }
}
