package ru.gorshkov.gameother.model.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gorshkov.gameother.model.entity.Message;
import ru.gorshkov.gameother.model.repository.MessageRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;

    public List<Message> getMessages() {
        return messageRepository.findAll();
    }

    public Long size() {
        return messageRepository.count();
    }

    public Message getMessageById(Long id) {
        return messageRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Message not found for id :: " + id));
    }

    @Transactional
    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }

    @Transactional
    public void deleteMessageById(Long id) {
        messageRepository.deleteById(id);
    }
}
