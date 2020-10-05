package com.dat250.feedapp.repositories;

import com.dat250.feedapp.models.IoTVotes;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class IoTVotesDAO implements DAO<IoTVotes> {
  private final EntityManager em;

  public IoTVotesDAO() {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
    em = factory.createEntityManager();
  }

  @Override
  public List<IoTVotes> read() {
    TypedQuery<IoTVotes> q = em.createQuery("Select u from IoTVotes u", IoTVotes.class);
    return q.getResultList();
  }

  @Override
  public IoTVotes read(int id) {
    return em.find(IoTVotes.class, id);
  }

  @Override
  public void create(IoTVotes iotVote) {
    em.getTransaction().begin();
    em.persist(iotVote);
    em.getTransaction().commit();
  }

  @Override
  public void update(IoTVotes iotVote) {
    em.getTransaction().begin();
    em.merge(iotVote);
    em.getTransaction().commit();
  }

  @Override
  public void delete(int id) {
    IoTVotes vote = em.find(IoTVotes.class, id);
    em.getTransaction().begin();
    em.remove(vote);
    em.getTransaction().commit();
  }
}