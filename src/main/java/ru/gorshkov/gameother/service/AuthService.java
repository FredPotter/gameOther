package ru.gorshkov.gameother.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gorshkov.gameother.DTO.requests.auth.AuthenticationRequest;
import ru.gorshkov.gameother.DTO.requests.auth.RegisterRequest;
import ru.gorshkov.gameother.DTO.responses.auth.AuthenticationResponse;
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

    @Transactional
    public AuthenticationResponse register(RegisterRequest request, Integer verifyCode) {
        var user = userService.getUserByLogin(request.getLogin());
        if (verifyCode.equals(user.getCode())) {
            user.setAccountStatus(AccountStatus.ACTIVE);
            user.setLastLoginDate(LocalDateTime.now());
            user.setBalance(0L);
            user.setCode(null);
            userService.saveUser(user);
            var jwtToken = jwtService.generateToken(user.getId(), user);
            return new AuthenticationResponse(jwtToken);
        } else {
            return new AuthenticationResponse("invalid code");
        }
    }

    @Transactional
    public boolean preRegister(RegisterRequest request, int verifyCode) {
        if (request.getLogin().length() > 7 && request.getLogin().length() < 15 && request.getUsername().length() > 2
        && request.getPassword().length() > 2) {
            var user = User.builder()
                    .userStatus(UserStatus.USER)
                    .login(request.getLogin())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .username(request.getUsername())
                    .accountStatus(AccountStatus.INACTIVE)
                    .registrationDate(LocalDateTime.now())
                    .country(countryService.getCountryByName(request.getCountryName()))
                    .code(verifyCode)
                    .build();
            if (userService.findUserByLoginOrUsername(request.getLogin(), request.getUsername())) {
                return false;
            } else {
                userService.saveUser(user);
                return true;
            }
        } else return false;
    }

    @Transactional
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getLogin(), request.getPassword())
        );
        var user = userService.getUserByLogin(request.getLogin());
        var jwtToken = jwtService.generateToken(user.getId(), user);
        return new AuthenticationResponse(jwtToken);
    }
}
