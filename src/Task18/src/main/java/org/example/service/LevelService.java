package org.example.service;

import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.example.dto.LevelDTO;
import org.springframework.stereotype.Service;
import org.example.entity.Level;
import org.example.repository.LevelRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class LevelService{
    private final LevelRepository levelRepository;

    private EntityManager entityManager;

    public Level add(LevelDTO dto) {
        Level game = Level.builder()
                .complexity(dto.getComplexity())
                .levelName(dto.getLevelName())
                .build();
        return levelRepository.save(game);
    }

    public List<Level> readAll() {
        return levelRepository.findAll();
    }

    public void delete(Long id) {
        levelRepository.deleteById(id);
    }

    public List<Level> findByComplexity(int complexity) { return levelRepository.findAllByComplexity(complexity);}

}