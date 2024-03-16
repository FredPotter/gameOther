package ru.gorshkov.gameother.model.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gorshkov.gameother.DTO.requests.rest.BuyOfferRequest;
import ru.gorshkov.gameother.enums.BuyerStatus;
import ru.gorshkov.gameother.enums.SellerStatus;
import ru.gorshkov.gameother.model.entity.Transaction;
import ru.gorshkov.gameother.model.repository.TransactionRepository;
import ru.gorshkov.gameother.service.JwtService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final UserService userService;
    private final OfferService offerService;
    private final JwtService jwtService;


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

    @Transactional
    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
    @Transactional
    public Transaction createTransaction(BuyOfferRequest request, String token) {
        String username = jwtService.extractUsername(token.split(" ")[1]);
        var buyer = userService.getUserByUsername(username);
        var offer = offerService.getOfferById(request.getOfferId());
        var seller = userService.getUserById(offer.getSeller().getId());
        return transactionRepository.save(Transaction.builder()
                .buyer(buyer)
                .seller(seller)
                .offer(offer)
                .quantityGoods(request.getQuantity())
                .pricePerLot(offer.getPricePerLot())
                .buyerStatus(BuyerStatus.WAITING)
                .sellerStatus(SellerStatus.WAITING)
                .build());
    }

    @Transactional
    public void deleteTransactionById(Long id) {
        transactionRepository.deleteById(id);
    }
}
