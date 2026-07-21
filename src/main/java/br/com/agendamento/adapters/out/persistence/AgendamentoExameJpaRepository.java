package br.com.agendamento.adapters.out.persistence;

import br.com.agendamento.domain.model.AgendamentoExameJava;
import org.springframework.data.jpa.repository.JpaRepository;

@Schema(description="interface AgendamentoExame para repository Spring Data JPA")
public interface AgendamentoExameJpaRepository extends JpaRepository<AgendamentoExameJava, Long> {
}
