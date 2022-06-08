package br.com.financeiro.despesa.ports.driven;

import br.com.financeiro.despesa.domain.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Long> {
}
