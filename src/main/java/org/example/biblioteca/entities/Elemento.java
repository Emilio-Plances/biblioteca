package org.example.biblioteca.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="libreria")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Elemento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sequenza_libreria")
    @SequenceGenerator(name="sequenza_libreria",initialValue = 1,allocationSize = 1)
    @Column(name = "codice_isbn")
    private int codiceISBN;
    private String Titolo;
    @Column(name = "anno_pubblicazione")
    private int annoPubblicazione;
    private int pagine;
    @OneToOne(mappedBy = "elementoPrestato",cascade = CascadeType.REMOVE)
    private Prestito prestito;

    public Elemento() {}
    public Elemento(String titolo, int annoPubblicazione, int pagine) {
        Titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.pagine = pagine;
    }

    public int getCodiceISBN() {
        return codiceISBN;
    }

    public String getTitolo() {
        return Titolo;
    }

    public void setTitolo(String titolo) {
        Titolo = titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getPagine() {
        return pagine;
    }

    public void setPagine(int pagine) {
        this.pagine = pagine;
    }

    public String toString() {
        return  "codiceISBN=" + codiceISBN +
                ", Titolo=" + Titolo +
                ", annoPubblicazione=" + annoPubblicazione +
                ", pagine=" + pagine;
    }
}
