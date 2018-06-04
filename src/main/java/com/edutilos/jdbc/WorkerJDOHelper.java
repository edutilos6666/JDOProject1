package com.edutilos.jdbc;


import com.edutilos.pojo.Worker;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class WorkerJDOHelper {
 private String embeddedUrl = "$objectdb/db/worker.odb";
 private EntityManagerFactory emf ;
    private EntityManager em;
    private EntityTransaction etx ;

    public WorkerJDOHelper() {

    }


    public void connect() {
        emf = Persistence.createEntityManagerFactory(embeddedUrl);
        em = emf.createEntityManager();
        etx = em.getTransaction();
    }

    public void disconnect() {
        if(em!= null)
        em.close();
        if(emf != null)
        emf.close();
    }

    public void saveWorker(Worker worker) {
        try {
           etx.begin();
            em.persist(worker);
            etx.commit();
        } catch(Exception ex) {
            ex.printStackTrace();
            etx.rollback();
        }
    }


    public void updateWorker(long id, Worker worker) {
        try {
            etx.begin();
            Worker _w = em.find(Worker.class, id);
            _w.setName(worker.getName());
            _w.setAge(worker.getAge());
            _w.setWage(worker.getWage());
            _w.setActive(worker.isActive());
            etx.commit();
        } catch(Exception ex) {
            ex.printStackTrace();
            etx.rollback();
        }
    }


    public void deleteWorker(long id) {
        try {
            etx.begin();
            Worker _w = em.find(Worker.class, id);
            em.remove(_w);
            etx.commit();
        } catch(Exception ex) {
            ex.printStackTrace();
            etx.rollback();
        }
    }

    public List<Worker> findAll() {
         List<Worker> list = em.createNamedQuery("findAll", Worker.class).getResultList();
        return list ;
    }

    public Worker findById(long id) {
        Worker w = em.createNamedQuery("findById", Worker.class)
                .setParameter("id", id)
                .getSingleResult();
        return w;
    }
}
