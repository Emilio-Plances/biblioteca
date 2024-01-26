package org.example.biblioteca.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name="utenti")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sequenza_utenti")
    @SequenceGenerator(name="sequenza_utenti",initialValue = 1,allocationSize = 1)
    @Column(name="numero_tessera")
    private int numeroTessera;
    private String nome;
    private String cognome;
    @Column(name="data_nascita")
    private LocalDate dataNascita;
    @OneToMany(mappedBy = "utente",cascade = CascadeType.REMOVE)
    private Set<Prestito> prestiti;

    public Utente() {}
    public Utente(String nome, String cognome, LocalDate dataNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
    }

    public int getNumeroTessera() {
        return numeroTessera;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public LocalDate getDataNascita() {
        return dataNascita;
    }
    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    @Override
    public String toString() {
        return  "numeroTessera=" + numeroTessera +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataNascita=" + dataNascita;
    }
}
