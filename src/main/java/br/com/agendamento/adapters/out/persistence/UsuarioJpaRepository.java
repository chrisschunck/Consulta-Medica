package br.com.agendamento.adapters.out.persistence;

import br.com.agendamento.domain.model.UsuarioJava;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

@Schema(description="interface Usuario para repository Spring Data JPA")
public interface UsuarioJpaRepository extends JpaRepository<UsuarioJava, Long> {
    Optional<UsuarioJava> findByEmail(String email);
    boolean existsByEmail(String email);
}
