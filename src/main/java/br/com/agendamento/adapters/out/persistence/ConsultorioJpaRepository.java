package br.com.agendamento.adapters.out.persistence;

import br.com.agendamento.domain.model.ConsultorioJava;
import org.springframework.data.jpa.repository.JpaRepository;

@Schema(description="interface Consultorio para repository Spring Data JPA")
public interface ConsultorioJpaRepository extends JpaRepository<ConsultorioJava, Long> {
}
