package ru.gorshkov.gameother.model.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gorshkov.gameother.model.repository.UserBlockingRepository;

@Service
@RequiredArgsConstructor
public class UserBlockingService {
    private final UserBlockingRepository userBlockingRepository;


}
