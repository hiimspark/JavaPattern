package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.entity.Game;
import org.example.entity.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Slf4j
@Service
public class SchedulingService {
    @Autowired
    private GameService gameService;
    @Autowired
    private LevelService levelService;

    private void writeGame() {
        List<Game> games = gameService.readAll();
        try {
            RandomAccessFile writer = new RandomAccessFile("backup/games.txt", "rw");
            writer.setLength(0);
            for (Game game : games) {
                String footStr = String.format("%d %s %s\n",
                        game.getId(),
                        game.getName(),
                        game.getCreationDate());
                writer.write(footStr.getBytes());
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeLevel() {
        List<Level> levels = levelService.readAll();
        try {
            RandomAccessFile writer = new RandomAccessFile("backup/level.txt", "rw");
            writer.setLength(0);
            for (Level level : levels) {
                String teamStr = String.format("%d %s %s\n",
                        level.getId(),
                        level.getComplexity(),
                        level.getLevelName());
                writer.write(teamStr.getBytes());
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Scheduled(cron = "* */30 * * * *")
    public void makeBackup() {
        writeGame();
        log.info("write games");
        writeLevel();
        log.info("write levels");
    }
}
