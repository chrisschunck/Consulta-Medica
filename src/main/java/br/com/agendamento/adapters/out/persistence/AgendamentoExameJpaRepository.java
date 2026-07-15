package br.com.agendamento.adapters.out.persistence;

import br.com.agendamento.domain.model.AgendamentoExameJava;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoExameJpaRepository extends JpaRepository<AgendamentoExameJava, Long> {
}
