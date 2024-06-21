package top.frankxxj.homework.backend.security.userrole;

import org.springframework.data.domain.Pageable;
import top.frankxxj.homework.backend.security.role.Role;

import java.util.List;
import java.util.UUID;

public interface UserRoleRelationService {
    void assignRole(UUID userId, Long roleId);

    void removeRole(UUID userId, Long roleId);

    List<Role> getRoles(UUID userId, Pageable pageable);
}
