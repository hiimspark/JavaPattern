package org.example.repository;

import org.example.entity.Level;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.example.entity.Level;
import java.util.List;


@Repository
@RequiredArgsConstructor
public class LevelRepository {
    private final SessionFactory sessionFactory;
    private Session session;
    @PostConstruct
    void init()
    {
        session = sessionFactory.openSession();
    }
    public void save(Level level)
    {
        var s = session.beginTransaction();
        session.persist(level);
        s.commit();
    }
    public List<Level> findAll()
    {
        var s = session.beginTransaction();
        var levels = session.createQuery("select u from Level u", Level.class).getResultList();
        s.commit();
        return levels;
    }

    public void deleteById(Long id)
    {
        var s = session.beginTransaction();
        session.remove(session.find(Level.class, id));
        s.commit();
    }


}