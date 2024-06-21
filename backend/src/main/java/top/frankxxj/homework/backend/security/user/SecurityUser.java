package top.frankxxj.homework.backend.security.user;

import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import top.frankxxj.homework.backend.security.role.SecurityRole;

import java.util.Collection;

@ToString
public class SecurityUser implements UserDetails {
    private final User user;

    public SecurityUser(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getUserRoleRelations().stream()
                .map(userRoleRelation -> new SecurityRole(userRoleRelation.getRole())).toList();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

}
