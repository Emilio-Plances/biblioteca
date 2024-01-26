package org.example.biblioteca.dao;

import jakarta.persistence.*;
import org.example.biblioteca.entities.Utente;

public class UtenteDao {
    private final EntityManagerFactory emf;
    private final EntityManager em;
    public UtenteDao() {
        emf= Persistence.createEntityManagerFactory("biblioteca");
        em=emf.createEntityManager();
    }
    public void aggiungiUtente(Utente u) throws EntityExistsException {
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.persist(u);
        et.commit();
        em.refresh(u);
    }
    public Utente cercaUtenteById(int id){
        return em.find(Utente.class,id);
    }
    public void  rimuoviUtente(int id){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.remove(cercaUtenteById(id));
        et.commit();
    }
    public void end(){
        em.close();
        emf.close();
    }
}
