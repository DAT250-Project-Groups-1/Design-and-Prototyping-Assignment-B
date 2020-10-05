package com.dat250.feedapp.repositories;

import com.dat250.feedapp.models.IoTDevice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class IoTDeviceDAO implements DAO<IoTDevice> {

    private final EntityManager em;

    public IoTDeviceDAO() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        em = factory.createEntityManager();
    }

    @Override
    public List<IoTDevice> read() {
        TypedQuery<IoTDevice> q = em.createQuery("Select u from IoTDevice u", IoTDevice.class);
        return q.getResultList();
    }

    @Override
    public IoTDevice read(int id) {
        return em.find(IoTDevice.class, id);
    }

    @Override
    public void create(IoTDevice ioTDevice) {
        em.getTransaction().begin();
        em.persist(ioTDevice);
        em.getTransaction().commit();
    }

    @Override
    public void update(IoTDevice ioTDevice) {
        em.getTransaction().begin();
        em.merge(ioTDevice);
        em.getTransaction().commit();
    }

    @Override
    public void delete(int id) {
        IoTDevice device = em.find(IoTDevice.class, id);
        em.getTransaction().begin();
        em.remove(device);
        em.getTransaction().commit();
    }
}
