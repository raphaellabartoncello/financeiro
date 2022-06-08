package br.com.financeiro.despesa.domain;

import javax.persistence.*;

@Entity
@Table(name = "despesa")
public class Despesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDespesa", nullable = false)
    private Long idDespesa;

    @Column(name = "nomeDespesa", length = 100, nullable = false)
    private String nomeDespesa;

    @Column(name = "valor", length = 10, nullable = false)
    private double valor;

    public Long getIdDespesa() {
        return idDespesa;
    }

    public void setIdDespesa(Long idDespesa) {
        this.idDespesa = idDespesa;
    }

    public String getNomeDespesa() {
        return nomeDespesa;
    }

    public void setNomeDespesa(String nomeDespesa) {
        this.nomeDespesa = nomeDespesa;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Despesa(Long idDespesa, String nomeDespesa, double valor){
        this.idDespesa = idDespesa;
        this.nomeDespesa = nomeDespesa;
        this.valor = valor;
    }

    public Despesa(){
        this.idDespesa = null;
        this.nomeDespesa = "";
        this.valor = 0.00;
    }
}
