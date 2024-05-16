package org.example.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.example.entity.Level;
import org.example.repository.LevelRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class LevelService{
    private final LevelRepository levelRepository;

    private EntityManager entityManager;

    public void add(Level level) {
        levelRepository.save(level);
    }

    public List<Level> readAll() {
        return levelRepository.findAll();
    }

    public void delete(Long id) {
        levelRepository.deleteById(id);
    }

    @Transactional
    public List<Level> findLevelByName(String name){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Level> cq = cb.createQuery(Level.class);
        Root<Level> root = cq.from(Level.class);
        Predicate namePredicate = cb.equal(root.get("levelname"), name);
        cq.where(namePredicate);

        return entityManager.createQuery(cq).getResultList();

    }

    @Transactional
    public List<Level> sortGamesByDate() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Level> cq = cb.createQuery(Level.class);
        Root<Level> root = cq.from(Level.class);
        cq.orderBy(cb.asc(root.get("complexity")));

        return entityManager.createQuery(cq).getResultList();
    }
}