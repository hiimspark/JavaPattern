package org.example.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.example.entity.Game;
import org.hibernate.query.Query;
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

    private EntityManager entityManager;

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

    @GetMapping("/name/asc")
    public List<Level> filterNamesAsc(){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Level> cq = cb.createQuery(Level.class);
        Root<Level> root = cq.from(Level.class);
        cq.select(root).orderBy(cb.asc(root.get("levelName")));
        Query<Level> query = (Query<Level>) entityManager.createQuery(cq);
        return query.getResultList();
    }

    @GetMapping("/name/desc")
    public List<Level> filterNamesDesc(){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Level> cq = cb.createQuery(Level.class);
        Root<Level> root = cq.from(Level.class);
        cq.select(root).orderBy(cb.desc(root.get("levelName")));
        Query<Level> query = (Query<Level>) entityManager.createQuery(cq);
        return query.getResultList();
    }

    @GetMapping("/compl/asc")
    public List<Level> filterComplexityAsc(){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Level> cq = cb.createQuery(Level.class);
        Root<Level> root = cq.from(Level.class);
        cq.select(root).orderBy(cb.asc(root.get("complexity")));
        Query<Level> query = (Query<Level>) entityManager.createQuery(cq);
        return query.getResultList();
    }

    @GetMapping("/compl/desc")
    public List<Level> filterComplexityDesc(){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Level> cq = cb.createQuery(Level.class);
        Root<Level> root = cq.from(Level.class);
        cq.select(root).orderBy(cb.desc(root.get("complexity")));
        Query<Level> query = (Query<Level>) entityManager.createQuery(cq);
        return query.getResultList();
    }
}
