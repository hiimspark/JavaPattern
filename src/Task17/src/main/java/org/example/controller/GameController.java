package org.example.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.hibernate.query.Query;
import org.springframework.web.bind.annotation.*;
import org.example.entity.Game;
import org.example.service.GameService;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/games")
public class GameController {
    private final GameService gameService;

    private EntityManager entityManager;

    @PostMapping("/add")
    public void createGame(@RequestBody Game game) {
        gameService.add(game);
    }

    @DeleteMapping("/{index}")
    public void deleteGame(@PathVariable long index) {
        gameService.delete(index);
    }

    @GetMapping
    public List<Game> getAllGames() {
        return gameService.readAll();
    }

    @GetMapping("/name/asc")
    public List<Game> filterNamesAsc(){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Game> cq = cb.createQuery(Game.class);
        Root<Game> root = cq.from(Game.class);
        cq.select(root).orderBy(cb.asc(root.get("name")));
        Query<Game> query = (Query<Game>) entityManager.createQuery(cq);
        return query.getResultList();
    }

    @GetMapping("/name/desc")
    public List<Game> filterNamesDesc(){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Game> cq = cb.createQuery(Game.class);
        Root<Game> root = cq.from(Game.class);
        cq.select(root).orderBy(cb.desc(root.get("name")));
        Query<Game> query = (Query<Game>) entityManager.createQuery(cq);
        return query.getResultList();
    }

    @GetMapping("/date/asc")
    public List<Game> filterDatesAsc(){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Game> cq = cb.createQuery(Game.class);
        Root<Game> root = cq.from(Game.class);
        cq.select(root).orderBy(cb.asc(root.get("creationdate")));
        Query<Game> query = (Query<Game>) entityManager.createQuery(cq);
        return query.getResultList();
    }

    @GetMapping("/date/desc")
    public List<Game> filterDatesDesc(){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Game> cq = cb.createQuery(Game.class);
        Root<Game> root = cq.from(Game.class);
        cq.select(root).orderBy(cb.desc(root.get("creationdate")));
        Query<Game> query = (Query<Game>) entityManager.createQuery(cq);
        return query.getResultList();
    }

}
