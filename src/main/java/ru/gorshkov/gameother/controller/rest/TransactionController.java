package ru.gorshkov.gameother.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gorshkov.gameother.DTO.entitiesDto.TransactionDto;
import ru.gorshkov.gameother.DTO.requests.rest.ConfirmAndRejectTransactionRequest;
import ru.gorshkov.gameother.DTO.responses.rest.ConfirmAndRejectTransactionResponse;
import ru.gorshkov.gameother.mapper.TransactionMapper;
import ru.gorshkov.gameother.model.entity.Transaction;
import ru.gorshkov.gameother.model.entity.User;
import ru.gorshkov.gameother.model.service.TransactionService;
import ru.gorshkov.gameother.model.service.UserService;
import ru.gorshkov.gameother.service.JwtService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/transaction")
@CrossOrigin(origins = "http://localhost:3000/")
public class TransactionController {
    private final TransactionService transactionService;
    private final UserService userService;
    private final JwtService jwtService;

    @GetMapping("/list")
    public ResponseEntity<List<TransactionDto>> getTransactions(@RequestHeader("Authorization") String token) {
        User user = userService.getUserByUsername(jwtService.extractUsername(token.split(" ")[1]));
        List<Transaction> list = transactionService.getTransactionsByUserId(user.getId());
        return ResponseEntity.ok(list.stream().map(TransactionMapper.INSTANCE::toDto).toList());
    }

    @PostMapping("/confirm")
    public ResponseEntity<ConfirmAndRejectTransactionResponse> confirmTransaction(@RequestBody ConfirmAndRejectTransactionRequest request, @RequestHeader("Authorization") String token) {
        User user = userService.getUserByUsername(jwtService.extractUsername(token.split(" ")[1]));
        try {
            transactionService.confirmTransaction(user, request.getId());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ConfirmAndRejectTransactionResponse(false, e.getMessage()));
        }
        return ResponseEntity.ok(new ConfirmAndRejectTransactionResponse(true, "OK"));
    }

    @PostMapping("/reject")
    public ResponseEntity<ConfirmAndRejectTransactionResponse> rejectTransaction(@RequestBody ConfirmAndRejectTransactionRequest request, @RequestHeader("Authorization") String token) {
        User user = userService.getUserByUsername(jwtService.extractUsername(token.split(" ")[1]));
        try {
            transactionService.rejectTransaction(user, request.getId());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ConfirmAndRejectTransactionResponse(false, e.getMessage()));
        }
        return ResponseEntity.ok(new ConfirmAndRejectTransactionResponse(true, "OK"));
    }

}
