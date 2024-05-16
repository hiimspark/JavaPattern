package org.example.service;

import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.LevelDTO;
import org.springframework.stereotype.Service;
import org.example.entity.Level;
import org.example.repository.LevelRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class LevelService{
    private final LevelRepository levelRepository;

    private EntityManager entityManager;

    public Level add(LevelDTO dto) {
        log.info("Level added");
        Level game = Level.builder()
                .complexity(dto.getComplexity())
                .levelName(dto.getLevelName())
                .build();
        return levelRepository.save(game);
    }

    public List<Level> readAll() {
        log.info("Levels have been read");
        return levelRepository.findAll();
    }

    public void delete(Long id) {
        log.info("A level has been deleted");
        levelRepository.deleteById(id);
    }

    public List<Level> findByComplexity(int complexity) {
        log.info("Levels with some complexity have been read");
        return levelRepository.findAllByComplexity(complexity);}

}