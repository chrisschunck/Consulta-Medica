package br.com.agendamento.adapters.out.persistence;

import br.com.agendamento.domain.model.AgendamentoJava;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoJpaRepository extends JpaRepository<AgendamentoJava, Long> {
}
