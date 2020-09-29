package com.dat250.feedapp.repositories;



import com.dat250.feedapp.models.Poll;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Repository
public class PollDAO implements DAO<Poll> {

    private EntityManager em;

    public PollDAO() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        em = factory.createEntityManager();
    }

    @Override
    public List<Poll> read() {
        Query q =em.createQuery("Select p from Poll p");
        return q.getResultList();
    }

    @Override
    public Poll read(int id) {
       return em.find(Poll.class, id);
    }

    @Override
    public void create(Poll poll) {
        em.getTransaction().begin();
        em.persist(poll);
        em.getTransaction().commit();
    }

    @Override
    public void update(Poll poll) {
        em.getTransaction().begin();
        em.merge(poll);
        em.getTransaction().commit();
    }

    @Override
    public void delete(int id) {
        Poll p = em.find(Poll.class, id);
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
    }
}
