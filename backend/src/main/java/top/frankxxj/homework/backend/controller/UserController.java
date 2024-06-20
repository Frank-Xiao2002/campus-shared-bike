package top.frankxxj.homework.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.frankxxj.homework.backend.service.UserService;
import top.frankxxj.homework.backend.user.User;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        User existingUser = userService.getUser(user.getEmail());
        if (existingUser != null) {
            return ResponseEntity.badRequest().body("注册用户已存在");
        }

        userService.registerUser(user);
        return ResponseEntity.ok("成功注册");
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestParam String email, @RequestParam String password) {
        User user = userService.getUser(email);
        if (user == null) {
            return ResponseEntity.badRequest().body("用户不存在");
        }

        // 验证密码
        if (!user.getPassword().equals(password)) {
            return ResponseEntity.badRequest().body("密码不正确");
        }

        return ResponseEntity.ok("登录成功");
    }
}

