package ru.gorshkov.gameother.model.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gorshkov.gameother.model.entity.MessageToSupport;
import ru.gorshkov.gameother.model.repository.MessageToSupportRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageToSupportService {
    private final MessageToSupportRepository messageToSupportRepository;

    public List<MessageToSupport> getMessagesToSupport() {
        return messageToSupportRepository.findAll();
    }

    public Long size() {
        return messageToSupportRepository.count();
    }

    public MessageToSupport getMessageToSupportById(Long id) {
        return messageToSupportRepository.findById(id).orElseThrow(() ->
                new RuntimeException("MessageToSupport not found for id :: " + id));
    }

    @Transactional
    public MessageToSupport saveMessageToSupport(MessageToSupport messageToSupport) {
        return messageToSupportRepository.save(messageToSupport);
    }

    @Transactional
    public void deleteMessageToSupportById(Long id) {
        messageToSupportRepository.deleteById(id);
    }
    //TODO: add method to get messages by user id
}
