package top.frankxxj.homework.backend.security.role;

public interface RoleService {
    Role create(String roleName);

    void delete(String roleName);

}
