package br.com.agendamento.adapters.out.persistence;

import br.com.agendamento.domain.model.ConvenioMedicoJava;
import org.springframework.data.jpa.repository.JpaRepository;

@Schema(description="interface ConvenioMedico para repository Spring Data JPA")
public interface ConvenioMedicoJpaRepository extends JpaRepository<ConvenioMedicoJava, Long> {
}
