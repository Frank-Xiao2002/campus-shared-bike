package top.frankxxj.homework.backend.security.role;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import top.frankxxj.homework.backend.security.userrole.UserRoleRelation;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "approle")
@NoArgsConstructor
@ToString
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "role", orphanRemoval = true)
    @ToString.Exclude
    private List<UserRoleRelation> userRoleRelations = new ArrayList<>();

    public Role(String name) {
        this.name = name;
    }

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
