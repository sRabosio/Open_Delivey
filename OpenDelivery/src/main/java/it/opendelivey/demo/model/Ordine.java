package it.opendelivey.demo.model;

import javax.persistence.*;

@Entity
public class Ordine {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;

        @ManyToOne

        Utente utente;
}