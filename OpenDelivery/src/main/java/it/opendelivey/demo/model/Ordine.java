package it.opendelivey.demo.model;

import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

//non prendiamo gli ordini che sono stati pagati/effettuati
//ci aspettiamo che sia attivo un solo ordine non acquistato alla volta
@Entity @Where(clause = "is_bought = false")
public class Ordine {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        //questo attributo segna se l'ordine è stato comprato o meno
        //in alternativa si può usare un'entità fattura
        @NotNull
        private boolean isBought = false;

        @ManyToOne
        @JoinColumn(name = "utente_id")
        private Utente utente;

        @OneToMany(mappedBy = "ordine")
        private Set<OrdineRecord> piatti = new HashSet<>();

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

        public static Ordine ordineSample(){
                Ordine ordine = new Ordine();
                ordine.setId(1);
                ordine.setUtente(Utente.utenteSample());
                return ordine;
        }

        public Set<OrdineRecord> getPiatti() {
                return piatti;
        }

        public void setPiatti(Set<OrdineRecord> piatti) {
                this.piatti = piatti;
        }
}