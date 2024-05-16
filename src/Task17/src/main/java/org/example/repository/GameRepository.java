package org.example.repository;

import org.example.entity.Level;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.example.entity.Game;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class GameRepository {
    private final SessionFactory sessionFactory;
    private Session session;
    @PostConstruct
    void init()
    {
        session = sessionFactory.openSession();
    }
    public void save(Game game)
    {
        var s = session.beginTransaction();
        session.persist(game);
        s.commit();
    }
    public List<Game> findAll()
    {
        var s = session.beginTransaction();
        var games = session.createQuery("select u from Game u", Game.class).getResultList();
        s.commit();
        return games;
    }

    public void deleteById(Long id)
    {
        var s = session.beginTransaction();
        session.remove(session.find(Game.class, id));
        s.commit();
    }


}