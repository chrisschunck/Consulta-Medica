package br.com.agendamento.adapters.out.persistence;

import br.com.agendamento.domain.model.ConvenioMedicoJava;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConvenioMedicoJpaRepository extends JpaRepository<ConvenioMedicoJava, Long> {
}
