package br.com.agendamento.adapters.out.persistence;

import br.com.agendamento.domain.model.ConsultorioJava;
import br.com.agendamento.domain.ports.out.ConsultorioRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Schema(description="classe ConsultorioRepository para repository adapter")
public class ConsultorioRepositoryAdapter implements ConsultorioRepositoryPort {

    private final ConsultorioJpaRepository jpaRepository;

    public ConsultorioRepositoryAdapter(ConsultorioJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public ConsultorioJava salvar(ConsultorioJava entidade) {
        return jpaRepository.save(entidade);
    }

    @Override
    public Optional<ConsultorioJava> buscarPorId(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<ConsultorioJava> listarTodos() {
        return jpaRepository.findAll();
    }

    @Override
    public void deletarPorId(Long id) {
        jpaRepository.deleteById(id);
    }
}
