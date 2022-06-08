package br.com.financeiro.despesa.domain;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

public class DespesaDto implements Serializable {

    private Long idDespesa;

    @NotEmpty(message = "O nome da despesa é obrigatório.")
    @NotNull(message = "O nome da despesa é obrigatório.")
    private String nomeDespesa;

    @NotEmpty(message = "O valor da despesa é obrigatório.")
    @NotNull(message = "O valor da despesa é obrigatório.")
    @Column(name = "valor", length = 10, nullable = false)
    private double valor;

    public DespesaDto(Long idDespesa, String nomeDespesa, double valor){
        this.idDespesa = idDespesa;
        this.nomeDespesa = nomeDespesa;
        this.valor = valor;
    }

    public DespesaDto(){
        this.idDespesa = null;
        this.nomeDespesa = "";
        this.valor = 0.00;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DespesaDto entity = (DespesaDto) o;
        return Objects.equals(this.idDespesa, entity.idDespesa) &&
                Objects.equals(this.nomeDespesa, entity.nomeDespesa) &&
                Objects.equals(this.valor, entity.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDespesa, nomeDespesa, valor);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "idDespesa = " + idDespesa + ", " +
                "nomeDespesa = " + nomeDespesa + ", " +
                "valor = " + valor + ")";
    }

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
}
