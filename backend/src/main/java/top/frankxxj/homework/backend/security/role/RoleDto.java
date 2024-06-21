package top.frankxxj.homework.backend.security.role;

import java.io.Serializable;

/**
 * DTO for {@link Role}
 */
public record RoleDto(String name) implements Serializable {
}