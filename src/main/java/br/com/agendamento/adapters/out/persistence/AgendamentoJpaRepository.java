package br.com.agendamento.adapters.out.persistence;

import br.com.agendamento.domain.model.AgendamentoJava;
import org.springframework.data.jpa.repository.JpaRepository;

@Schema(description="interface Agendamento para repository Spring Data JPA")
public interface AgendamentoJpaRepository extends JpaRepository<AgendamentoJava, Long> {
}
