package top.frankxxj.homework.backend.user.role.connection;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import top.frankxxj.homework.backend.user.User;
import top.frankxxj.homework.backend.user.role.Role;

@Getter
@Setter
@Entity
@Table(name = "user_role")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

}