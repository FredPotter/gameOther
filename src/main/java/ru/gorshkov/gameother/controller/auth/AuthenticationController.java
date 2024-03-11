package ru.gorshkov.gameother.controller.auth;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gorshkov.gameother.DTO.requests.AuthenticationRequest;
import ru.gorshkov.gameother.DTO.requests.RegisterRequest;
import ru.gorshkov.gameother.DTO.responses.AuthenticationResponse;
import ru.gorshkov.gameother.gateway.SmsSender;
import ru.gorshkov.gameother.service.AuthService;
import ru.gorshkov.gameother.util.CodeGen;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthenticationController {

    private final AuthService authService;
    private final SmsSender smsSender;

    @PostMapping("/register1")
    public ResponseEntity<String> register1(
            @RequestBody RegisterRequest request){
        int verifyCode = CodeGen.generateCode();
        if (authService.preRegister(request, verifyCode)) {
            smsSender.sendSms(request.getLogin(), String.valueOf(verifyCode));
            return ResponseEntity.ok("OK");
        }
        return ResponseEntity.status(400).body("User already exists");
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request, int code){
        var response = authService.register(request, code);
        if ("invalid code".equals(response.getToken())) {
            return ResponseEntity.status(400).body(response);
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request){
        log.debug(request.toString());
        return ResponseEntity.ok(authService.authenticate(request));
    }

    //TODO: /refresh verifyCode & /logout & /forgotPassword & /changePassword
}
