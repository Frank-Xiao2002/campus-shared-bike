package top.frankxxj.homework.backend.security.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class BasicUserService implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    @Override
    public User create(UserDto userDto) {
        log.info("Creating user: {}", userDto.email());
        var user = new User();
        user.setEmail(userDto.email().trim().toLowerCase());
        user.setPassword(encoder.encode(userDto.password()));
        userRepository.save(user);
        log.info("User created: {}", user.getEmail());
        return user;
    }

    @Override
    public void updatePassword(UserDto userDto) {
        var u = ((SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        Assert.isTrue(Objects.equals(u.getUsername(), userDto.email()),
                "You can only update your own password");
        var user = userRepository.findByEmailIgnoreCase(userDto.email())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        user.setPassword(encoder.encode(userDto.password()));
        userRepository.save(user);
        log.info("Password updated for user: {}", user.getEmail());
    }

    @Override
    public Boolean checkEmail(String email) {
        return userRepository.existsByEmailIgnoreCase(email.trim());
    }


}
