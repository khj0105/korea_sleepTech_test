package com.example.korea_sleepTech_Test.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Builder
@AllArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + role));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    // 계정 만료 여부(true: 만료되지 않음)
    @Override public boolean isAccountNonExpired() {
        return true;
    }
    // 계정 잠김 여부(true: 잠기지 않음)
    @Override public boolean isAccountNonLocked() {
        return true;
    }
    // 인증 정보 만료 여부
    @Override public boolean isCredentialsNonExpired() {
        return true;
    }
    // 계정 활성화 여부
    @Override public boolean isEnabled() {
        return true;
    }
}