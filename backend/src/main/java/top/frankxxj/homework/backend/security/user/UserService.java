package top.frankxxj.homework.backend.security.user;

public interface UserService {
    User create(UserDto userDto);

    void updatePassword(UserDto userDto);

    Boolean checkEmail(String email);
}
