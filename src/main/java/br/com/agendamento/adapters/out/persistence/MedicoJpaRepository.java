package br.com.agendamento.adapters.out.persistence;

import br.com.agendamento.domain.model.MedicoJava;
import org.springframework.data.jpa.repository.JpaRepository;

@Schema(description="interface Medico para repository Spring Data JPA")
public interface MedicoJpaRepository extends JpaRepository<MedicoJava, Long> {
}
