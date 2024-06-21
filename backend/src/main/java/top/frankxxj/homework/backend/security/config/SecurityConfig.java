package top.frankxxj.homework.backend.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import top.frankxxj.homework.backend.security.user.UserRepository;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {
    @Bean
    PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserDetailsService userDetailsService(UserRepository userRepository) {
        return new CustomUserDetailsManager(userRepository);
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> {
            auth.requestMatchers(HttpMethod.POST, "/user/**").permitAll();
            auth.requestMatchers(HttpMethod.GET, "/user/check**").permitAll();
            auth.requestMatchers(HttpMethod.PUT, "/user/**").hasAuthority("USER");
            auth.requestMatchers("/userrole/**").hasAuthority("ADMIN");
            auth.requestMatchers(HttpMethod.POST, "/broken/**").permitAll();
            auth.requestMatchers(HttpMethod.PUT, "/broken/**").hasAnyAuthority("ADMIN", "REPAIRMEN");
            auth.requestMatchers("/role/**").hasAuthority("ADMIN");
            auth.requestMatchers(HttpMethod.GET, "/bike/**").permitAll();
            auth.requestMatchers(HttpMethod.POST, "/bike/**").hasAuthority("ADMIN");
            auth.requestMatchers(HttpMethod.DELETE, "/bike/**").hasAuthority("ADMIN");
            auth.requestMatchers("/ride/**").permitAll();
            auth.anyRequest().authenticated();
        });
        http.httpBasic(withDefaults());
        http.formLogin(withDefaults());
        return http.build();
    }

}
