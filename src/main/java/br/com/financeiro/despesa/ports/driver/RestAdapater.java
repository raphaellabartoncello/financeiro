package br.com.financeiro.despesa.ports.driver;

import br.com.financeiro.despesa.domain.DespesaDto;
import br.com.financeiro.despesa.domain.DespesaService;
import br.com.financeiro.despesa.domain.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/{id}")
    public ResponseEntity<DespesaDto> getProdutoById(@PathVariable(value = "id") Long idDespesa)
            throws ResourceNotFoundException {
        DespesaDto produto = despesaService.consultarDespesa(idDespesa)
                .orElseThrow(() -> new ResourceNotFoundException(MSG_NAO_ENCONTRADO + idDespesa));
        return ResponseEntity.ok().body(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DespesaDto> updateDespesa(@PathVariable(value = "id") Long idDespesa, @Valid @RequestBody DespesaDto despesaDetails)
            throws ResourceNotFoundException {
        DespesaDto despesa = despesaService.consultarDespesa(idDespesa)
                .orElseThrow(() -> new ResourceNotFoundException(MSG_NAO_ENCONTRADO + idDespesa));

        despesa.setNomeDespesa(despesaDetails.getNomeDespesa());
        despesa.setValor(despesaDetails.getValor());
        final DespesaDto updatedDespesa = despesaService.atualizarDespesa(despesa);
        return ResponseEntity.ok(updatedDespesa);
    }

    @PostMapping("/")
    public DespesaDto createDespesa(@Valid @RequestBody DespesaDto despesa) {
        return despesaService.atualizarDespesa(despesa);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteDespesa(@PathVariable(value = "id") Long idDespesa)
            throws ResourceNotFoundException {
        DespesaDto despesa = despesaService.consultarDespesa(idDespesa)
                .orElseThrow(() -> new ResourceNotFoundException(MSG_NAO_ENCONTRADO + idDespesa));

        despesaService.excluirDespesa(despesa);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
