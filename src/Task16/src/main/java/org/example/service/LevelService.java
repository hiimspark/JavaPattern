package org.example.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.example.entity.Level;
import org.example.repository.LevelRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class LevelService{
    private final LevelRepository levelRepository;

    public void add(Level level) {
        levelRepository.save(level);
    }

    public List<Level> readAll() {
        return levelRepository.findAll();
    }

    public void delete(Long id) {
        levelRepository.deleteById(id);
    }
}