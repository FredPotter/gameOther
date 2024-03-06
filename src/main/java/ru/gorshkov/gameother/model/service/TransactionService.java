package ru.gorshkov.gameother.model.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gorshkov.gameother.model.entity.Transaction;
import ru.gorshkov.gameother.model.repository.TransactionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public List<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }
    public Long size() {
        return transactionRepository.count();
    }
    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Transaction not found for id :: " + id));
    }
    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
    public void deleteTransactionById(Long id) {
        transactionRepository.deleteById(id);
    }
}
