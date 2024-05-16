package org.example.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.example.dto.GameDTO;
import org.hibernate.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.entity.Game;
import org.example.service.GameService;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class GameController {
    private final GameService gameService;

    private EntityManager entityManager;

    @RequestMapping(value = "/game", method = RequestMethod.POST)
    public ResponseEntity<Game> create(@RequestBody GameDTO dto) {
        return new ResponseEntity<>(gameService.add(dto), HttpStatus.OK);
    }

    @DeleteMapping("/game/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        gameService.delete(id);
        return HttpStatus.OK;
    }

    @RequestMapping(value = "/game", method = RequestMethod.GET)
    public ResponseEntity<List<Game>> readAll() {
        return new ResponseEntity<>(gameService.readAll(), HttpStatus.OK);
    }

    @GetMapping("/game/name/asc")
    public List<Game> filterNamesAsc(){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Game> cq = cb.createQuery(Game.class);
        Root<Game> root = cq.from(Game.class);
        cq.select(root).orderBy(cb.asc(root.get("name")));
        Query<Game> query = (Query<Game>) entityManager.createQuery(cq);
        return query.getResultList();
    }

    @GetMapping("/game/name/desc")
    public List<Game> filterNamesDesc(){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Game> cq = cb.createQuery(Game.class);
        Root<Game> root = cq.from(Game.class);
        cq.select(root).orderBy(cb.desc(root.get("name")));
        Query<Game> query = (Query<Game>) entityManager.createQuery(cq);
        return query.getResultList();
    }

    @GetMapping("/game/date/asc")
    public List<Game> filterDatesAsc(){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Game> cq = cb.createQuery(Game.class);
        Root<Game> root = cq.from(Game.class);
        cq.select(root).orderBy(cb.asc(root.get("creationdate")));
        Query<Game> query = (Query<Game>) entityManager.createQuery(cq);
        return query.getResultList();
    }

    @GetMapping("/game/date/desc")
    public List<Game> filterDatesDesc(){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Game> cq = cb.createQuery(Game.class);
        Root<Game> root = cq.from(Game.class);
        cq.select(root).orderBy(cb.desc(root.get("creationdate")));
        Query<Game> query = (Query<Game>) entityManager.createQuery(cq);
        return query.getResultList();
    }

}
