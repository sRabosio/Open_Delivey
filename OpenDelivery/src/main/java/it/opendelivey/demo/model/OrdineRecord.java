package it.opendelivey.demo.model;

import org.aspectj.weaver.ast.Or;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class OrdineRecord {

    @ManyToOne @JoinColumn
    private Ordine ordine;

    @ManyToOne @JoinColumn
    private Piatto prodotto;

    @NotNull @Min(1)
    private Integer amount;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public OrdineRecord() {
    }

    public OrdineRecord(Ordine ordine, Piatto prodotto, Integer amount) {
        this.ordine = ordine;
        this.prodotto = prodotto;
        this.amount = amount;
    }

    public static OrdineRecord ordineRecordSample(){
        return new OrdineRecord(

        );
    }

    public Ordine getOrdine() {
        return ordine;
    }

    public void setOrdine(Ordine ordine) {
        this.ordine = ordine;
    }

    public Piatto getProdotto() {
        return prodotto;
    }

    public void setProdotto(Piatto prodotto) {
        this.prodotto = prodotto;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
