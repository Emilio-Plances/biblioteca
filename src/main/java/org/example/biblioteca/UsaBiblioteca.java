package org.example.biblioteca;

import org.example.biblioteca.dao.ElementoDao;
import org.example.biblioteca.dao.PrestitoDao;
import org.example.biblioteca.dao.UtenteDao;
import org.example.biblioteca.entities.*;
import org.example.biblioteca.enums.Genere;
import org.example.biblioteca.enums.Periodicita;
import org.hibernate.exception.ConstraintViolationException;
import org.postgresql.util.PSQLException;

import java.time.LocalDate;

public class UsaBiblioteca {
    public static void main(String[] args) {
        ElementoDao elementoDao=new ElementoDao();
        PrestitoDao prestitoDao=new PrestitoDao();
        UtenteDao utenteDao=new UtenteDao();

        //Crea e aggiungi un Utente
//        Utente u1=new Utente("Emilio","Plances", LocalDate.of(1997,3,7));
//        utenteDao.aggiungiUtente(u1);
//        Utente u2=new Utente("Mauro","Cassoni", LocalDate.of(1994,1,10));
//        utenteDao.aggiungiUtente(u2);
//        Utente u3=new Utente("Emanuele","Barone", LocalDate.of(1996,5,22));
//        utenteDao.aggiungiUtente(u2);

        //Prende utenti esistenti nel database
        Utente u1=utenteDao.cercaUtenteById(1);
        Utente u2=utenteDao.cercaUtenteById(2);
        Utente u3=utenteDao.cercaUtenteById(3);


        //Crea e aggiungi un Libro
//        Libro l1=new Libro("Harry Potter",2000,400,"J.K.Rowling", Genere.FANTASIA);
//        elementoDao.aggiungiElemento(l1);

        //Crea e aggiungi una Rivista
//        Rivista r1=new Rivista("Cioè",2024,20, Periodicita.SETTIMANALE);
//        elementoDao.aggiungiElemento(r1);

        //Prende Elementi esistenti nel database
        Elemento el1=elementoDao.cercaElementoById(1);
        Elemento el2=elementoDao.cercaElementoById(2);


        //Crea e aggiungi un Prestito
        Prestito p1=new Prestito(u1,el2,LocalDate.now());
        try{
            prestitoDao.aggiungiPrestito(p1);
        }catch(Exception ex){
            System.out.println("Il libro è già in prestito");
        }







        elementoDao.end();
        prestitoDao.end();
        utenteDao.end();
    }
}
