package ru.gorshkov.gameother.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.gorshkov.gameother.enums.AccountStatus;
import ru.gorshkov.gameother.enums.UserStatus;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq")
    @SequenceGenerator(name="users_seq", allocationSize=1)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

    @Column(nullable = false)
    private String login;

    @Column
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String username;

    @Column
    private Long balance;

    @Column(nullable = false)
    private AccountStatus accountStatus;

    @Column(nullable = false)
    private LocalDateTime registrationDate;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @Column
    private String pathToAvatar;

    @Column
    private LocalDateTime lastLoginDate;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(userStatus.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return AccountStatus.ACTIVE.equals(accountStatus);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
