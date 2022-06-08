package br.com.financeiro.despesa.domain;

import br.com.financeiro.despesa.ports.driver.DespesaMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DespesaMapperImpl implements DespesaMapper {
    @Override
    public Despesa DespesaDtoToDespesa(DespesaDto despesaDto) {
        if(despesaDto == null){
            return new Despesa();
        } else {
            return new Despesa(
                    despesaDto.getIdDespesa(),
                    despesaDto.getNomeDespesa(),
                    despesaDto.getValor()
            );
        }
    }

    @Override
    public List<Despesa> DespesaDtoToDespesa(List<DespesaDto> despesaDto) {
        return despesaDto.stream().map(this::DespesaDtoToDespesa).collect(Collectors.toList());
    }

    @Override
    public DespesaDto DespesaToDespesaDto(Despesa despesa) {
        if(despesa == null){
            return new DespesaDto();
        } else {
            return new DespesaDto(
                    despesa.getIdDespesa(),
                    despesa.getNomeDespesa(),
                    despesa.getValor()
            );
        }
    }

    @Override
    public List<DespesaDto> DespesaToDespesaDto(List<Despesa> despesa) {
        return despesa.stream().map(this::DespesaToDespesaDto).collect(Collectors.toList());
    }
}
