package org.example.repository;

import org.example.entity.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LevelRepository extends JpaRepository<Level, Long> {
    List<Level> findAllByComplexity(int complexity);
}