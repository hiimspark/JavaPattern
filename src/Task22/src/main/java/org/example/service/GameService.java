package org.example.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.GameDTO;
import org.springframework.stereotype.Service;
import org.example.entity.Game;
import org.example.repository.GameRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class GameService{
    private final GameRepository gameRepository;

    private final EmailService emailService;

    @Transactional
    public Game add(GameDTO dto) {
        log.info("Game added");
        emailService.sendSimpleMessage("Game added","Game added", "1hiimspark@gmail.com");
        Game game = Game.builder()
                .name(dto.getName())
                .creationDate(dto.getCreationDate())
                .build();
        return gameRepository.save(game);
    }

    @Transactional
    public List<Game> readAll() {
        log.info("Games have been read");
        return gameRepository.findAll();
    }

    @Transactional
    public void delete(Long id) {
        log.info("A game has been deleted");
        gameRepository.deleteById(id);
    }


}