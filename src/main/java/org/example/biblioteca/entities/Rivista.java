package org.example.biblioteca.entities;

import jakarta.persistence.*;
import org.example.biblioteca.enums.Periodicita;

@Entity
@Table(name="riviste")
public class Rivista extends Elemento {
    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;

    public Rivista() {}

    public Rivista(String titolo, int annoPubblicazione, int pagine, Periodicita periodicita) {
        super(titolo, annoPubblicazione, pagine);
        this.periodicita = periodicita;
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return  super.toString()+
                "periodicita=" + periodicita;
    }
}
