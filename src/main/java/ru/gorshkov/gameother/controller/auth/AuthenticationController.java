package ru.gorshkov.gameother.controller.auth;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gorshkov.gameother.DTO.requests.auth.AuthenticationRequest;
import ru.gorshkov.gameother.DTO.requests.auth.RegisterRequest;
import ru.gorshkov.gameother.DTO.responses.auth.AuthenticationResponse;
import ru.gorshkov.gameother.gateway.sms.AbstractSmsSender;
import ru.gorshkov.gameother.service.AuthService;
import ru.gorshkov.gameother.util.TelUtil;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthenticationController {

    private final AuthService authService;
    @PostMapping("/pre-register")
    public ResponseEntity<String> preRegister(
            @RequestBody RegisterRequest request){
        //AbstractSmsSender smsSender = TelUtil.getSmsSender(request.getTelephoneRegion());
        int verifyCode = TelUtil.generateCode();
        System.out.println(verifyCode);
        if (authService.preRegister(request, verifyCode)) {
            //smsSender.sendSms(request.getLogin(), String.valueOf(verifyCode)); //TODO: MADE ASYNC
            System.out.println("SMS sent: " + verifyCode);
            return ResponseEntity.ok("OK");
        }
        return ResponseEntity.status(400).body("User already exists");
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request,@RequestParam Integer code){
        var response = authService.register(request, code);
        if ("invalid code".equals(response.getToken())) {
            return ResponseEntity.status(400).body(response);
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authService.authenticate(request));
    }

    //TODO: /refresh verifyCode & /logout & /forgotPassword & /changePassword
}
