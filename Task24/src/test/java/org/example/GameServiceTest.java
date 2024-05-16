package org.example;

import org.example.dto.GameDTO;
import org.example.entity.Game;
import org.example.repository.GameRepository;
import org.example.service.GameService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GameServiceTest {

    @Mock
    private GameRepository gameRepository;

    @InjectMocks
    private GameService gameService;


    @Test
    public void testCreate() {
        GameDTO dto = new GameDTO("Game1", "16.05.2024");
        Game expectedGame = new Game(null, "Game1", "16.05.2024");

        when(gameRepository.save(any())).thenReturn(expectedGame);

        Game createdGame = gameService.add(dto);

        verify(gameRepository, times(1)).save(any());
        assertEquals(expectedGame, createdGame);
    }

    @Test
    public void testReadAll() {

        GameDTO dto1 = new GameDTO("Game1", "16.05.2024");
        Game expectedGame1 = new Game(null, "Game1", "16.05.2024");

        GameDTO dto2 = new GameDTO("Game2", "16.05.2024");
        Game expectedGame2 = new Game(null, "Game2", "16.05.2024");

        List<Game> expectedGames = Arrays.asList(
                expectedGame1,
                expectedGame2
        );

        when(gameRepository.findAll()).thenReturn(expectedGames);

        List<Game> games = gameService.readAll();

        verify(gameRepository, times(1)).findAll();
        assertEquals(expectedGames, games);
    }


    @Test
    public void testDelete() {
        Long id = 1L;

        gameService.delete(id);

        verify(gameRepository, times(1)).deleteById(id);
    }
}