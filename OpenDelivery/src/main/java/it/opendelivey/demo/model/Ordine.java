package it.opendelivey.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

//non prendiamo gli ordini che sono stati pagati/effettuati
//ci aspettiamo che sia attivo un solo ordine non acquistato alla volta
@Entity
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

        public Ordine(Utente utente) {
                this.utente = utente;
        }



        @OneToMany(mappedBy = "ordine", cascade = CascadeType.ALL)
        private Set<OrdineRecord> piatti = new HashSet<>();

        public Ordine() {

        }

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

        public boolean isBought() {
                return isBought;
        }

        public void setBought(boolean bought) {
                isBought = bought;
        }

        public void addRecord(OrdineRecord record){
                piatti.add(record);
        }

        public void removeRecordById(Integer id){
                piatti.removeIf(p->p.getId().equals(id));
        }
}