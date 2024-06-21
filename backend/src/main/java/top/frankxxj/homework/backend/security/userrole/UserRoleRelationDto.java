package top.frankxxj.homework.backend.security.userrole;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link UserRoleRelation}
 */
public record UserRoleRelationDto(UUID userId,
                                  Long roleId) implements Serializable {
}