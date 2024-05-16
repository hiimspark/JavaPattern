package org.example.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.example.entity.Level;
import org.example.service.LevelService;
import java.util.ArrayList;
import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/levels")
public class LevelController {

    private final LevelService levelService;
    @PostMapping("/add")
    public void createLevel(@RequestBody Level level) {
        levelService.add(level);
    }

    @DeleteMapping("/{index}")
    public void deleteLevel(@PathVariable long index) {
        levelService.delete(index);
    }

    @GetMapping()
    public List<Level> getAllLevels() {
        return levelService.readAll();
    }
}
