package ru.gorshkov.gameother.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ru.gorshkov.gameother.DTO.requests.rest.ChangeBalanceRequest;
import ru.gorshkov.gameother.model.service.UserService;
import ru.gorshkov.gameother.service.JwtService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/payment")
public class PaymentController {
    private final UserService userService;
    private final JwtService jwtService;

    @GetMapping("/balance/{id}")
    public ResponseEntity<String> getBalance(@PathVariable Long id, @RequestHeader("Authorization") String token) {
        var user = userService.getUserById(id);
        if(jwtService.extractUsername(token.split(" ")[1]).equals(user.getUsername())) {
            return ResponseEntity.ok(user.getBalance().toString());
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/balance/{id}")
    @Transactional
    public ResponseEntity<String> changeBalance(@PathVariable Long id,
                                                @RequestHeader("Authorization") String token,
                                                @RequestBody ChangeBalanceRequest request) {
        var user = userService.getUserById(id);
        if(jwtService.extractUsername(token.split(" ")[1]).equals(user.getUsername())) {
            user.setBalance(user.getBalance() + request.getAmount());
            userService.saveUser(user);
            return ResponseEntity.ok(user.getBalance().toString());
        }
        return ResponseEntity.badRequest().build();
    }
}
