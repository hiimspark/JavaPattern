package org.example.controller;

import org.springframework.web.bind.annotation.*;
import org.example.entity.Level;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/levels")
public class LevelController {
    private List<Level> levels = new ArrayList<>();

    @PostMapping("/add")
    public void createLevel(@RequestBody Level level) {
        levels.add(level);
    }

    @DeleteMapping("/{index}")
    public void deleteLevel(@PathVariable int index) {
        levels.remove(index);
    }

    @GetMapping()
    public List<Level> getAllLevels() {
        return levels;
    }
}
