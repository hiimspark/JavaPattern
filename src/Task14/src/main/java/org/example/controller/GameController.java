package org.example.controller;

import org.springframework.web.bind.annotation.*;
import org.example.entity.Game;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {
    private List<Game> games = new ArrayList<>();

    @PostMapping("/add")
    public void createGame(@RequestBody Game game) {
        games.add(game);
    }

    @DeleteMapping("/{index}")
    public void deleteGame(@PathVariable int index) {
        games.remove(index);
    }

    @GetMapping
    public List<Game> getAllGames() {
        return games;
    }
}
