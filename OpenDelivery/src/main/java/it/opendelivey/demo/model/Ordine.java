package it.opendelivey.demo.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Ordine {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;


        @ManyToOne
        @JoinColumn(name = "utente_id")
        private Utente utente;


        @JoinColumn
        @ManyToMany
        private Set<Piatto> piatti = new HashSet<>();

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