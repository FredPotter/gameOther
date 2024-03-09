package ru.gorshkov.gameother.model.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gorshkov.gameother.model.entity.UserBlocking;
import ru.gorshkov.gameother.model.repository.UserBlockingRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserBlockingService {
    private final UserBlockingRepository userBlockingRepository;

    public List<UserBlocking> getUserBlockings() {
        return userBlockingRepository.findAll();
    }

    public Long size() {
        return userBlockingRepository.count();
    }

    @Transactional
    public void blockUser(UserBlocking userBlocking) {
        userBlockingRepository.save(userBlocking);
    }

    @Transactional
    public void unblockUser(Long id) {
        userBlockingRepository.deleteById(id);
    }

    public boolean isUserBlocked(Long id) {
        return userBlockingRepository.existsById(id);
    }

    public UserBlocking getUserBlockingById(Long id) {
        return userBlockingRepository.findById(id).orElseThrow(() ->
                new RuntimeException("UserBlocking not found for id :: " + id));
    }
}
