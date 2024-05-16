package org.example.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.example.entity.Game;
import org.example.service.GameService;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/games")
public class GameController {
    private final GameService gameService;
    @PostMapping("/add")
    public void createGame(@RequestBody Game game) {
        gameService.add(game);
    }

    @DeleteMapping("/{index}")
    public void deleteGame(@PathVariable long index) {
        gameService.delete(index);
    }

    @GetMapping
    public List<Game> getAllGames() {
        return gameService.readAll();
    }
}
