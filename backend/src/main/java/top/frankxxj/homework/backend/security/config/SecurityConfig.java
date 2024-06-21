package top.frankxxj.homework.backend.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
            auth.requestMatchers("/public/**").permitAll();
            auth.requestMatchers("/admin/**").hasRole("ADMIN");
            auth.requestMatchers("/user/**").hasRole("USER");
            auth.anyRequest().authenticated();
        });
        http.httpBasic(withDefaults());
        http.formLogin(cus -> {
            cus.defaultSuccessUrl("/public");
        });
        return http.build();
    }

//    @Bean
//    AuthenticationManager authenticationManager(AuthenticationManagerBuilder builder,
//                                                CustomAuthenticationProvider customAuthenticationProvider) throws Exception {
//        builder.authenticationProvider(customAuthenticationProvider);
//        return builder.build();
//    }
}
