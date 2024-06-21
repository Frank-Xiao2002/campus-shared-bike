package top.frankxxj.homework.backend.security.role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    void deleteByName(String name);
}