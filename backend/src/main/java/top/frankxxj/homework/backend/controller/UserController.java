package top.frankxxj.homework.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import top.frankxxj.homework.backend.service.UserService;
import top.frankxxj.homework.backend.user.User;
import top.frankxxj.homework.backend.utils.R;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public R registerUser(@RequestBody User user) {
        User user1 = userService.getUser(user.getEmail());
        if (user1 != null) {
            return R.error("注册用户已存在");
        }
        // 对密码进行加密
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userService.registerUser(user);
        return R.ok("成功注册");
    }

    @PostMapping("/login")
    public R loginUser(@RequestParam String email,@RequestParam String password) {
        User user1 = userService.getUser(email);
        if(user1 == null){
            return R.error("用户不存在");
        }

        // 创建BCryptPasswordEncoder对象
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        // 验证密码
        if (!passwordEncoder.matches(password, user1.getPassword())) {
            return R.error("密码不正确");
        }

        return R.ok("登录成功");

    }
}

