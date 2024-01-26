package org.example.biblioteca.dao;

import jakarta.persistence.*;
import org.example.biblioteca.entities.Elemento;

public class ElementoDao {
    private final EntityManagerFactory emf;
    private final EntityManager em;
    public ElementoDao() {
        emf= Persistence.createEntityManagerFactory("biblioteca");
        em=emf.createEntityManager();
    }
    public void aggiungiElemento(Elemento el) throws EntityExistsException {
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.persist(el);
        et.commit();
        em.refresh(el);
    }
    public Elemento cercaElementoById(int id){
        return em.find(Elemento.class,id);
    }
    public void  rimuoviElemento(int id){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.remove(cercaElementoById(id));
        et.commit();
    }
    public void end(){
        em.close();
        emf.close();
    }
}
