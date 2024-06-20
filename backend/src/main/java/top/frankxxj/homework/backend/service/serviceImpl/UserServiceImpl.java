package top.frankxxj.homework.backend.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.frankxxj.homework.backend.service.UserService;
import top.frankxxj.homework.backend.user.User;
import top.frankxxj.homework.backend.user.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String registerUser(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            return "Email is already in use!";
        }

        userRepository.save(user);
        return "User registered successfully!";
    }

    @Override
    public String loginUser(String email, String password) {
        User user = userRepository.findByEmail(email);

        if (user == null || !user.getPassword().equals(password)) {
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
