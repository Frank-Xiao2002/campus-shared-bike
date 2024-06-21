package top.frankxxj.homework.backend.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;
import top.frankxxj.homework.backend.security.user.SecurityUser;
import top.frankxxj.homework.backend.security.user.UserRepository;

@Component
@RequiredArgsConstructor
public class CustomUserDetailsManager implements UserDetailsManager {
    private final UserRepository userRepository;

    @Override
    public void createUser(UserDetails user) {
        // TODO: 6/21/2024
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateUser(UserDetails user) {
        // TODO: 6/21/2024
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteUser(String username) {
        userRepository.deleteByEmailIgnoreCase(username);
    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {
        // TODO: 6/21/2024
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean userExists(String username) {
        return userRepository.existsByEmailIgnoreCase(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findByEmailIgnoreCase(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new SecurityUser(user);
    }
}
