package org.example.biblioteca;

import org.example.biblioteca.dao.ElementoDao;
import org.example.biblioteca.dao.PrestitoDao;
import org.example.biblioteca.dao.UtenteDao;
import org.example.biblioteca.entities.*;
import org.example.biblioteca.enums.Genere;
import org.example.biblioteca.enums.Periodicita;

import java.time.LocalDate;

public class UsaBiblioteca {
    public static final ElementoDao elementoDao=new ElementoDao();
    public static final PrestitoDao prestitoDao=new PrestitoDao();
    public static final UtenteDao utenteDao=new UtenteDao();
    public static void main(String[] args) {

        //Crea e aggiungi un Utente
        Utente u1=creaUtente("Emilio","Plances", LocalDate.of(1997,3,7));
        Utente u2=creaUtente("Mauro","Cassoni", LocalDate.of(1994,1,10));
        Utente u3=creaUtente("Emanuele","Barone", LocalDate.of(1996,5,22));

        //Prende utenti esistenti nel database
//        Utente u1=utenteDao.cercaUtenteById(1);
//        Utente u2=utenteDao.cercaUtenteById(2);
//        Utente u3=utenteDao.cercaUtenteById(3);


        //Crea e aggiungi un Libro
        Libro l1=creaLibro("Harry Potter",2000,400,"J.K.Rowling", Genere.FANTASIA);
        Libro l2=creaLibro("Il Signore degli Anelli",1990,700,"Talkien",Genere.FANTASIA);
        Libro l3=creaLibro("Hunger Games",2000,300,"Suzanne Collins",Genere.FANTASCIENZA);

        //Crea e aggiungi una Rivista
        Rivista r1=creaRivista("Cioè",2024,20, Periodicita.SETTIMANALE);
        Rivista r2=creaRivista("In Cucina Con Ciccio",2020,35,Periodicita.MENSILE);

        //Prende Elementi esistenti nel database e li legge
//        Elemento el1=elementoDao.cercaElementoById(1);
//        Elemento el2=elementoDao.cercaElementoById(2);
//        stampaElemento(el1);
//        stampaElemento(el2);

        //Crea e aggiungi un Prestito
        try{
            Prestito p1=creaPrestito(u1,l1);
            Prestito p2=creaPrestito(u2,l2);
            Prestito p3=creaPrestito(u1,l3);
            Prestito p4=creaPrestito(u2,r1);
            Prestito p5=creaPrestito(u2,r2);

        }catch(Exception ex){
            System.out.println("Il libro è già in prestito");
        }

        elementoDao.cercaElementiPerAnno(2000).forEach(el-> System.out.println(el.toString()));
        elementoDao.cercaElementiPerAutore("J.K.Rowling").forEach(el-> System.out.println(el.toString()));
        elementoDao.cercaElementiPerTitolo("s").forEach(el-> System.out.println(el.toString()));
        elementoDao.cercaLibriPrestatiAUtente(1).forEach(el-> System.out.println(el.toString()));

        prestitoDao.prestitiScaduti().forEach(el-> System.out.println(el.toString()));

        elementoDao.end();
        prestitoDao.end();
        utenteDao.end();
    }
    public static Libro creaLibro(String titolo,int annoUscita,int numPagine,String autore,Genere genere){
        Libro l=new Libro(titolo,annoUscita,numPagine,autore, genere);
        elementoDao.aggiungiElemento(l);
        return l;
    }
    public static Rivista creaRivista(String titolo, int annoUscita, int numPagine, Periodicita periodicita){
        Rivista r=new Rivista(titolo,annoUscita,numPagine,periodicita);
        elementoDao.aggiungiElemento(r);
        return r;
    }
    public static Utente creaUtente(String nome,String cognome,LocalDate dataNascita){
        Utente u=new Utente(nome,cognome, dataNascita);
        utenteDao.aggiungiUtente(u);
        return u;
    }
    public static Prestito creaPrestito(Utente utente,Elemento elemento)throws Exception{
        Prestito p=new Prestito(utente,elemento,LocalDate.now());
        prestitoDao.aggiungiPrestito(p);
        return p;
    }
    public static void stampaElemento(Elemento el){
        if(el instanceof Libro l){
            System.out.println(l);
        } else if (el instanceof Rivista r) {
            System.out.println(r);
        }
    }
}
