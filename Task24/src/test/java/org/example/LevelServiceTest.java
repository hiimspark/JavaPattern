package org.example;


import org.example.dto.LevelDTO;
import org.example.entity.Level;
import org.example.repository.LevelRepository;
import org.example.service.LevelService;
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
public class LevelServiceTest {

    @Mock
    private LevelRepository levelRepository;

    @InjectMocks
    private LevelService levelService;


    @Test
    public void testCreate() {
        LevelDTO dto = new LevelDTO(5, "Level1");
        Level expectedLevel = new Level(null, 5, "Level1");

        when(levelRepository.save(any())).thenReturn(expectedLevel);

        Level createdLevel = levelService.add(dto);

        verify(levelRepository, times(1)).save(any());
        assertEquals(expectedLevel, createdLevel);
    }

    @Test
    public void testReadAll() {
        LevelDTO dto1 = new LevelDTO(5, "Level1");
        Level expectedLevel1 = new Level(null, 5, "Level1");

        LevelDTO dto2 = new LevelDTO(6, "Level2");
        Level expectedLevel2 = new Level(null, 6, "Level2");

        List<Level> expectedGames = Arrays.asList(
                expectedLevel1,
                expectedLevel2
        );

        when(levelRepository.findAll()).thenReturn(expectedGames);

        List<Level> games = levelService.readAll();

        verify(levelRepository, times(1)).findAll();
        assertEquals(expectedGames, games);
    }

    @Test
    public void testReadByComplexity() {
        LevelDTO dto1 = new LevelDTO(5, "Level1");
        Level expectedLevel1 = new Level(null, 5, "Level1");

        LevelDTO dto2 = new LevelDTO(6, "Level2");
        Level expectedLevel2 = new Level(null, 6, "Level2");

        List<Level> expectedGames = Arrays.asList(
                expectedLevel1
        );

        when(levelRepository.findAllByComplexity(5)).thenReturn(expectedGames);

        List<Level> games = levelService.findByComplexity(5);

        verify(levelRepository, times(1)).findAllByComplexity(5);
        assertEquals(expectedGames, games);
    }


    @Test
    public void testDelete() {
        Long id = 1L;

        levelService.delete(id);

        verify(levelRepository, times(1)).deleteById(id);
    }
}
