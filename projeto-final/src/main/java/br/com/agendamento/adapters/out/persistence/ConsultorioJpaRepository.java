package br.com.agendamento.adapters.out.persistence;

import br.com.agendamento.domain.model.ConsultorioJava;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultorioJpaRepository extends JpaRepository<ConsultorioJava, Long> {
}
