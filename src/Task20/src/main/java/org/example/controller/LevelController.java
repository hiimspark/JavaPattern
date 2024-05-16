package org.example.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.example.dto.LevelDTO;
import org.hibernate.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.entity.Level;
import org.example.service.LevelService;
import java.util.List;


@RestController
@AllArgsConstructor
public class LevelController {

    private final LevelService levelService;

    private EntityManager entityManager;

    @RequestMapping(value = "/level", method = RequestMethod.POST)
    public ResponseEntity<Level> create(@RequestBody LevelDTO dto) {
        return new ResponseEntity<>(levelService.add(dto), HttpStatus.OK);
    }

    @DeleteMapping("/level/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        levelService.delete(id);
        return HttpStatus.OK;
    }

    @RequestMapping(value = "/level", method = RequestMethod.GET)
    public ResponseEntity<List<Level>> readAll() {
        return new ResponseEntity<>(levelService.readAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/level/{complexity}", method = RequestMethod.GET)
    public ResponseEntity<List<Level>> readAll(@PathVariable int complexity) {
        return new ResponseEntity<>(levelService.findByComplexity(complexity), HttpStatus.OK);
    }

    @GetMapping("/level/name/asc")
    public List<Level> filterNamesAsc(){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Level> cq = cb.createQuery(Level.class);
        Root<Level> root = cq.from(Level.class);
        cq.select(root).orderBy(cb.asc(root.get("levelName")));
        Query<Level> query = (Query<Level>) entityManager.createQuery(cq);
        return query.getResultList();
    }

    @GetMapping("/level/name/desc")
    public List<Level> filterNamesDesc(){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Level> cq = cb.createQuery(Level.class);
        Root<Level> root = cq.from(Level.class);
        cq.select(root).orderBy(cb.desc(root.get("levelName")));
        Query<Level> query = (Query<Level>) entityManager.createQuery(cq);
        return query.getResultList();
    }

    @GetMapping("/level/compl/asc")
    public List<Level> filterComplexityAsc(){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Level> cq = cb.createQuery(Level.class);
        Root<Level> root = cq.from(Level.class);
        cq.select(root).orderBy(cb.asc(root.get("complexity")));
        Query<Level> query = (Query<Level>) entityManager.createQuery(cq);
        return query.getResultList();
    }

    @GetMapping("/level/compl/desc")
    public List<Level> filterComplexityDesc(){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Level> cq = cb.createQuery(Level.class);
        Root<Level> root = cq.from(Level.class);
        cq.select(root).orderBy(cb.desc(root.get("complexity")));
        Query<Level> query = (Query<Level>) entityManager.createQuery(cq);
        return query.getResultList();
    }
}
