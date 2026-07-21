package br.com.agendamento.adapters.out.persistence;

import br.com.agendamento.domain.model.ReceitaExamesJava;
import org.springframework.data.jpa.repository.JpaRepository;

@Schema(description="interface ReceitaExames para repository Spring Data JPA")
public interface ReceitaExamesJpaRepository extends JpaRepository<ReceitaExamesJava, Long> {
}
