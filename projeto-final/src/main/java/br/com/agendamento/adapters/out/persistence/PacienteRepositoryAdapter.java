package br.com.agendamento.adapters.out.persistence;

import br.com.agendamento.domain.model.PacienteJava;
import br.com.agendamento.domain.ports.out.PacienteRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PacienteRepositoryAdapter implements PacienteRepositoryPort {

    private final PacienteJpaRepository jpaRepository;

    public PacienteRepositoryAdapter(PacienteJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public PacienteJava salvar(PacienteJava entidade) {
        return jpaRepository.save(entidade);
    }

    @Override
    public Optional<PacienteJava> buscarPorId(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<PacienteJava> listarTodos() {
        return jpaRepository.findAll();
    }

    @Override
    public void deletarPorId(Long id) {
        jpaRepository.deleteById(id);
    }
}
