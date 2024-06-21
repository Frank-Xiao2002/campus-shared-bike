package top.frankxxj.homework.backend.security.userrole;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRelationRepository extends JpaRepository<UserRoleRelation, Long> {
}