package br.com.agendamento.adapters.out.persistence;

import br.com.agendamento.domain.model.ReceitaExamesJava;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceitaExamesJpaRepository extends JpaRepository<ReceitaExamesJava, Long> {
}
