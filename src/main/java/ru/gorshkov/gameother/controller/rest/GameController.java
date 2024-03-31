package ru.gorshkov.gameother.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gorshkov.gameother.DTO.entitiesDto.GameDto;
import ru.gorshkov.gameother.DTO.entitiesDto.OfferDto;
import ru.gorshkov.gameother.mapper.GameMapper;
import ru.gorshkov.gameother.mapper.OfferMapper;
import ru.gorshkov.gameother.model.entity.Game;
import ru.gorshkov.gameother.model.entity.Offer;
import ru.gorshkov.gameother.model.service.GameService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/game")
@CrossOrigin(origins = "http://localhost:3000/")
public class GameController {
    private final GameService gameService;

    @GetMapping("/list")
    public ResponseEntity<List<GameDto>> getGames() {
        List<Game> list = gameService.getGames();
        return ResponseEntity.ok(list.stream().map(GameMapper.INSTANCE::toDto).toList());
    }
}
