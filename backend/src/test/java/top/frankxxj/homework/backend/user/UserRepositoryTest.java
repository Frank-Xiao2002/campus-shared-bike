package top.frankxxj.homework.backend.user;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.util.Assert;
import top.frankxxj.homework.backend.user.role.Role;
import top.frankxxj.homework.backend.user.role.RoleRepository;
import top.frankxxj.homework.backend.user.role.connection.UserRole;
import top.frankxxj.homework.backend.user.role.connection.UserRoleRepository;

import java.util.List;
import java.util.UUID;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRoleRepository userRoleRepository;
    private static UUID id;

    @Order(1)
    @Test
    void createUser() {
        var user = User.builder().email("Xiao670127@126.com").password("123456").build();
        var savedUser = userRepository.save(user);
        System.out.println("savedUser = " + savedUser);
        id = savedUser.getId();
        System.out.println("id = " + id);
    }

    @Test
    @Order(2)
    void addRole() {
        var user1 = User.builder().email("Xiao670127@126.com").password("123456").build();
        var savedUser = userRepository.save(user1);
        var role1 = roleRepository.save(new Role(null, "role1"));
        var role2 = roleRepository.save(new Role(null, "role2"));
        System.out.println(userRepository.findAll());
        userRepository.findById(savedUser.getId()).ifPresent(
                user -> {
                    var r1 = UserRole.builder()
                            .role(role1)
                            .user(user).build();
                    var r2 = UserRole.builder()
                            .role(role2)
                            .user(user).build();
//                    user.setUserRoles(Set.of(r1, r2));
                    userRoleRepository.saveAll(List.of(r1, r2));
                }
        );
        userRepository.findById(savedUser.getId()).ifPresent(user -> {
            System.out.println("user = " + user);
            user.getUserRoles().forEach(System.out::println);
        });
    }

    @Test
    @Order(3)
    void checkRole() {
        var all = roleRepository.findAll();
        all.forEach(System.out::println);
        Assert.notEmpty(all, "Role should not be empty");
        Assert.isTrue(all.size() == 2, "Role should have 2 elements");
    }

    @Test
    @Order(4)
    void deleteUser() {
        userRepository.deleteById(id);
    }

    @Test
    @Order(5)
    void checkRole2() {
        var all = roleRepository.findAll();
        Assert.isTrue(all.isEmpty(), "Role should be empty");
    }
}