package org.example.biblioteca.dao;

import jakarta.persistence.*;
import org.example.biblioteca.entities.Prestito;

import java.util.List;

public class PrestitoDao {
    private final EntityManagerFactory emf;
    private final EntityManager em;
    public PrestitoDao() {
        emf= Persistence.createEntityManagerFactory("biblioteca");
        em=emf.createEntityManager();
    }
    public void aggiungiPrestito(Prestito p) throws Exception {
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.persist(p);
        et.commit();
        em.refresh(p);
    }
    public Prestito cercaPrestitoById(int id){
        return em.find(Prestito.class,id);
    }
    public void  rimuoviPrestito(int id){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.remove(cercaPrestitoById(id));
        et.commit();
    }
    public List<Prestito> prestitiScaduti(){
        Query q=em.createNamedQuery("scadutoNonRestituito");
        return q.getResultList();
    }
    public void end(){
        em.close();
        emf.close();
    }
}
