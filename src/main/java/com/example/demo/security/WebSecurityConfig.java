package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.demo.MyUser;
import com.example.demo.MyUserList;

@Configuration
public class WebSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        InMemoryUserDetailsManager mgr = new InMemoryUserDetailsManager();
        for (MyUser u : MyUserList.users) {
            mgr.createUser(User.withUsername(u.getId())
                .password(u.getPassword())
                .roles("USER")
                .build());
        }
        return mgr;
    }

	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // ①ログインページとログアウト後リダイレクト用パラメータ、
            //    CSS/JS といった静的リソースをまず許可
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/login",            // ログイン画面
                    "../static/**"           // CSS
                ).permitAll()
                // ②それ以外はすべて認証必須
                .anyRequest().authenticated()
            )
            // フォームログイン設定
            .formLogin(form -> form
                .loginPage("/login")       // カスタムログイン画面
                .defaultSuccessUrl("/home", true)
                .failureUrl("/login?error")
                .permitAll()
            )
            // ログアウト設定
            .logout(logout -> logout
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
                .logoutSuccessUrl("/login?logout")
                .permitAll()
            );

        return http.build();
    }
}
