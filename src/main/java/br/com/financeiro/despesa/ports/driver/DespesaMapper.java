package br.com.financeiro.despesa.ports.driver;

import br.com.financeiro.despesa.domain.Despesa;
import br.com.financeiro.despesa.domain.DespesaDto;

import java.util.List;

public interface DespesaMapper {

    Despesa DespesaDtoToDespesa(DespesaDto despesaDto);

    List<Despesa> DespesaDtoToDespesa(List<DespesaDto> despesaDto);

    DespesaDto DespesaToDespesaDto(Despesa despesa);

    List<DespesaDto> DespesaToDespesaDto(List<Despesa> despesa);

}
