package top.frankxxj.homework.backend.security.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import top.frankxxj.homework.backend.security.userrole.UserRoleRelation;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "appuser")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    @ToString.Exclude
    private String password;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.REMOVE}, fetch = FetchType.EAGER)
    @ToString.Exclude
    private Set<UserRoleRelation> userRoleRelations;

    public User(UUID id) {
        this.id = id;
    }
}
