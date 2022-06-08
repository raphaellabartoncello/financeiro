package br.com.financeiro.despesa.domain;

import br.com.financeiro.despesa.ports.driven.DespesaRepository;
import br.com.financeiro.despesa.ports.driver.DespesaMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DespesaService {
    private final DespesaRepository despesaRepository;
    private final DespesaMapper despesaMapper;

    public DespesaService(DespesaRepository despesaRepository, DespesaMapper despesaMapper) {
        this.despesaRepository = despesaRepository;
        this.despesaMapper = despesaMapper;
    }

    public List<DespesaDto> consultarDespesas(){
        return despesaMapper.DespesaToDespesaDto(despesaRepository.findAll());
    }

    public Optional<DespesaDto> consultarDespesa(Long idDespesa){
        Optional<Despesa> obj = despesaRepository.findById(idDespesa);
        if(obj.isPresent()){
            return Optional.ofNullable(despesaMapper.DespesaToDespesaDto(obj.get()));
        }else {
            return Optional.empty();
        }
    }

    public DespesaDto atualizarDespesa(DespesaDto despesa){
        Despesa d = despesaMapper.DespesaDtoToDespesa(despesa);
        d = despesaRepository.save(d);
        return despesaMapper.DespesaToDespesaDto(d);
    }

    public void excluirDespesa(DespesaDto despesa){
        despesaRepository.delete(despesaMapper.DespesaDtoToDespesa(despesa));
    }

}
