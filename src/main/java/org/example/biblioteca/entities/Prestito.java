package org.example.biblioteca.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name="prestiti")
public class Prestito {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sequenza_prestiti")
    @SequenceGenerator(name="sequenza_prestiti",initialValue = 1,allocationSize = 1)
    @Column(name="id_prestito")
    private int idPrestito;
    @ManyToOne
    @JoinColumn(name = "utente_fk")
    private Utente utente;
    @OneToOne
    @JoinColumn(name="elemento_fk")
    private Elemento elementoPrestato;
    @Column(name="data_inizio_prestito")
    private LocalDate dataInizioPrestito;
    @Column(name="data_fine_prestito")
    private LocalDate dataFinePrestito;
    @Column(name="data_consegna")
    private LocalDate dataConsegna;

    public Prestito() {}

    public Prestito(Utente utente, Elemento elementoPrestato, LocalDate dataInizioPrestito) {
        this.utente = utente;
        this.elementoPrestato = elementoPrestato;
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataFinePrestito = dataInizioPrestito.plusDays(30);
    }

    public int getIdPrestito() {
        return idPrestito;
    }
    public Utente getUtente() {
        return utente;
    }
    public void setUtente(Utente utente) {
        this.utente = utente;
    }
    public Elemento getElemento() {
        return elementoPrestato;
    }
    public void setElemento(Elemento elemento) {
        this.elementoPrestato = elemento;
    }
    public LocalDate getDataInizioPrestito() {
        return dataInizioPrestito;
    }
    public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
    }
    public LocalDate getDataFinePrestito() {
        return dataFinePrestito;
    }
    public void setDataFinePrestito(LocalDate dataFinePrestito) {
        this.dataFinePrestito = dataFinePrestito;
    }
    public LocalDate getDataConsegna() {
        return dataConsegna;
    }
    public void setDataConsegna(LocalDate dataConsegna) {
        this.dataConsegna = dataConsegna;
    }

    @Override
    public String toString() {
        return  "idPrestito=" + idPrestito +
                ", utente=" + utente +
                ", elemento=" + elementoPrestato +
                ", dataInizioPrestito=" + dataInizioPrestito +
                ", dataFinePrestito=" + dataFinePrestito +
                ", dataConsegna=" + dataConsegna;
    }
}
