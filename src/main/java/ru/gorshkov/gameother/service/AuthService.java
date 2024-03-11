package ru.gorshkov.gameother.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.gorshkov.gameother.DTO.requests.AuthenticationRequest;
import ru.gorshkov.gameother.DTO.requests.RegisterRequest;
import ru.gorshkov.gameother.DTO.responses.AuthenticationResponse;
import ru.gorshkov.gameother.enums.AccountStatus;
import ru.gorshkov.gameother.enums.UserStatus;
import ru.gorshkov.gameother.model.entity.User;
import ru.gorshkov.gameother.model.service.CountryService;
import ru.gorshkov.gameother.model.service.UserService;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserService userService;
    private final CountryService countryService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .userStatus(UserStatus.USER)
                .login(request.getLogin())
                .password(passwordEncoder.encode(request.getPassword()))
                .username(request.getUsername())
                .accountStatus(AccountStatus.ACTIVE)
                .registrationDate(LocalDateTime.now())
                .country(countryService.getCountryByName(request.getCountryName()))
                .build();
        userService.saveUser(user);
        var jwtToken = jwtService.generateToken(user.getId(), user);
        return new AuthenticationResponse(jwtToken);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getLogin(), request.getPassword())
        );
        var user = userService.getUserByLogin(request.getLogin());
        var jwtToken = jwtService.generateToken(user.getId(), user);
        return new AuthenticationResponse(jwtToken);
    }
}
