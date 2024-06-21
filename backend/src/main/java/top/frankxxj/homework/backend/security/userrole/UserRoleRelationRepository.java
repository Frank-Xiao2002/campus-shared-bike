package top.frankxxj.homework.backend.security.userrole;

import org.springframework.data.jpa.repository.JpaRepository;
import top.frankxxj.homework.backend.security.role.Role;
import top.frankxxj.homework.backend.security.user.User;

public interface UserRoleRelationRepository extends JpaRepository<UserRoleRelation, Long> {
    void deleteByUserAndRole(User user, Role role);
}