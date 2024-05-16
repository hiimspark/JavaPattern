package org.example.service;

import lombok.AllArgsConstructor;
import org.example.dto.GameDTO;
import org.springframework.stereotype.Service;
import org.example.entity.Game;
import org.example.repository.GameRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class GameService{
    private final GameRepository gameRepository;

    public Game add(GameDTO dto) {
        Game game = Game.builder()
                .name(dto.getName())
                .creationDate(dto.getCreationDate())
                .build();
        return gameRepository.save(game);
    }

    public List<Game> readAll() {
        return gameRepository.findAll();
    }

    public void delete(Long id) {
        gameRepository.deleteById(id);
    }


}