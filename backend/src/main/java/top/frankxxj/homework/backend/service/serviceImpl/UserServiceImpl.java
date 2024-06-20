package top.frankxxj.homework.backend.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import top.frankxxj.homework.backend.service.UserService;
import top.frankxxj.homework.backend.user.User;
import top.frankxxj.homework.backend.user.UserRepository;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public String registerUser(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            return "Email is already in use!";
        }

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User registered successfully!";
    }

    public String loginUser(String email, String password) {
        User user = userRepository.findByEmail(email);

        if (user == null || !bCryptPasswordEncoder.matches(password, user.getPassword())) {
            return "Invalid email or password!";
        }

        if (!user.getIsEnabled()) {
            return "User account is disabled!";
        }

        return "Login successful!";
    }

    @Override
    public User getUser(String email) {
        return userRepository.findByEmail(email);
    }
}
