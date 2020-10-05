package com.dat250.feedapp.repositories;

import com.dat250.feedapp.models.IoTVote;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class IoTVoteDAO implements DAO<IoTVote> {
    private final EntityManager em;

    public IoTVoteDAO() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        em = factory.createEntityManager();
    }

    @Override
    public List<IoTVote> read() {
        TypedQuery<IoTVote> q = em.createQuery("Select u from IoTVote u", IoTVote.class);
        return q.getResultList();
    }

    @Override
    public IoTVote read(int id) {
        return em.find(IoTVote.class, id);
    }

    @Override
    public void create(IoTVote iotVote) {
        em.getTransaction().begin();
        em.persist(iotVote);
        em.getTransaction().commit();
    }

    @Override
    public void update(IoTVote iotVote) {
        em.getTransaction().begin();
        em.merge(iotVote);
        em.getTransaction().commit();
    }

    @Override
    public void delete(int id) {
        IoTVote vote = em.find(IoTVote.class, id);
        em.getTransaction().begin();
        em.remove(vote);
        em.getTransaction().commit();
    }
}
