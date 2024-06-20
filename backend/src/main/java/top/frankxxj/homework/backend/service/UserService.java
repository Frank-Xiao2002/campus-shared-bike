package top.frankxxj.homework.backend.service;

import top.frankxxj.homework.backend.user.User;

public interface UserService {
    public String registerUser(User user);

    public String loginUser(String email, String password);

    User getUser(String email);
}
