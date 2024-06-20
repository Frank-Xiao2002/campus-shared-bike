package top.frankxxj.homework.backend.user;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<User> findAll();

    User findById(UUID id);

    User findByEmail(String email);

    User saveUser(User user);

    void deleteUser(UUID id);

    void addRole(UUID userId, String roleName);

    void removeRole(UUID userId, String roleName);


}
