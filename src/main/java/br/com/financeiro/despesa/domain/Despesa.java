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
    private Long valor;

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

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }
}
