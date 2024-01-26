package org.example.biblioteca.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import org.example.biblioteca.enums.Genere;

@Entity
@Table(name="libri")
public class Libro extends Elemento {
    private String autore;
    @Enumerated(EnumType.STRING)
    private Genere genere;

    public Libro() {}

    public Libro(String titolo, int annoPubblicazione, int pagine, String autore, Genere genere) {
        super(titolo, annoPubblicazione, pagine);
        this.autore = autore;
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }


    @Override
    public String toString() {
        return  super.toString()+
                ", autore='" + autore + '\'' +
                ", genere=" + genere;
    }
}
