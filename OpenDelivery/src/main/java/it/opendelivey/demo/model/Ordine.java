package it.opendelivey.demo.model;

import javax.persistence.*;

@Entity
public class Ordine {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;

        @ManyToOne
        @JoinColumn
        private Utente utente;


        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public Utente getUtente() {
                return utente;
        }

        public void setUtente(Utente utente) {
                this.utente = utente;
        }
}