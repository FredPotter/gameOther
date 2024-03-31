package ru.gorshkov.gameother.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ru.gorshkov.gameother.DTO.requests.rest.ChangeBalanceRequest;
import ru.gorshkov.gameother.DTO.responses.rest.GetBalanceResponse;
import ru.gorshkov.gameother.model.entity.User;
import ru.gorshkov.gameother.model.service.UserService;
import ru.gorshkov.gameother.service.JwtService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/payment")
@CrossOrigin(origins = "http://localhost:3000/")
public class PaymentController {
    private final UserService userService;
    private final JwtService jwtService;

    @GetMapping("/balance")
    public ResponseEntity<GetBalanceResponse> getBalance(@RequestHeader("Authorization") String token) {
        User user = userService.getUserByUsername(jwtService.extractUsername(token.split(" ")[1]));
        GetBalanceResponse response = new GetBalanceResponse(user.getBalance().toString());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/balance")
    @Transactional
    public ResponseEntity<GetBalanceResponse> changeBalance(@RequestHeader("Authorization") String token,
                                                @RequestBody ChangeBalanceRequest request) {
        User user = userService.getUserByUsername(jwtService.extractUsername(token.split(" ")[1]));
        user.setBalance(user.getBalance() + request.getAmount());
        userService.saveUser(user);
        GetBalanceResponse response = new GetBalanceResponse(user.getBalance().toString());
        return ResponseEntity.ok(response);
    }
}
