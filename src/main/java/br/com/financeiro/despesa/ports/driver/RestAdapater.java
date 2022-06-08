package br.com.financeiro.despesa.ports.driver;

import br.com.financeiro.despesa.domain.DespesaDto;
import br.com.financeiro.despesa.domain.DespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@Validated
@RequestMapping("/despesa")
public class RestAdapater {
    private final DespesaService despesaService;
    private static final String MSG_NAO_ENCONTRADO = "Despesa não encontrada com o id :: ";

    @Autowired
    public RestAdapater(DespesaService despesaService) {
        this.despesaService = despesaService;
    }

    @GetMapping("/")
    public List<DespesaDto> getAllDespesas(){
        return despesaService.consultarDespesas();
    }
    
}
