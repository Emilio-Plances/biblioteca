package org.example.biblioteca.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="libreria")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NamedQuery(name="cercaPerAnno", query = "SELECT e FROM Elemento e WHERE e.annoPubblicazione=:anno")
@NamedQuery(name="cercaPerAutore",query = "SELECT e FROM Elemento e WHERE e.autore=:autore")
@NamedQuery(name="cercaPerTitolo",query = "SELECT e FROM Elemento e WHERE LOWER(e.titolo) LIKE LOWER(concat('%',:titolo,'%'))")
@NamedQuery(name="libriPrestati",query = "SELECT e FROM Elemento e WHERE e.prestito.utente.numeroTessera=:id and e.prestito.dataConsegna IS NULL")
public abstract class Elemento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sequenza_libreria")
    @SequenceGenerator(name="sequenza_libreria",initialValue = 1,allocationSize = 1)
    @Column(name = "codice_isbn")
    private int codiceISBN;
    private String titolo;
    @Column(name = "anno_pubblicazione")
    private int annoPubblicazione;
    private int pagine;
    @OneToOne(mappedBy = "elementoPrestato",cascade = CascadeType.REMOVE)
    private Prestito prestito;

    public Elemento() {}
    public Elemento(String titolo, int annoPubblicazione, int pagine) {
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.pagine = pagine;
    }

    public int getCodiceISBN() {
        return codiceISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        titolo = titolo;
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
                ", titolo=" + titolo +
                ", annoPubblicazione=" + annoPubblicazione +
                ", pagine=" + pagine;
    }
}
