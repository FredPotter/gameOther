package ru.gorshkov.gameother.model.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gorshkov.gameother.model.entity.Game;
import ru.gorshkov.gameother.model.repository.GameRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {
    private final GameRepository gameRepository;

    public List<Game> getGames() {
        return gameRepository.findAll();
    }

    public Long size() {
        return gameRepository.count();
    }

    public Game getGameById(Long id) {
        return gameRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Game not found for id :: " + id));
    }

    @Transactional
    public Game saveGame(Game game) {
        return gameRepository.save(game);
    }

    @Transactional
    public void deleteGameById(Long id) {
        gameRepository.deleteById(id);
    }
}
