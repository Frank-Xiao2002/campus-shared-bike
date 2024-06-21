package top.frankxxj.homework.backend.security.user;

import java.io.Serializable;

/**
 * DTO for {@link User}
 */
public record UserDto(String email,
                      String password) implements Serializable {
}