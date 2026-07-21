package br.com.agendamento.adapters.out.persistence;

import br.com.agendamento.domain.model.PacienteJava;
import org.springframework.data.jpa.repository.JpaRepository;

@Schema(description="interface Paciente para repository Spring Data JPA")
public interface PacienteJpaRepository extends JpaRepository<PacienteJava, Long> {
}
