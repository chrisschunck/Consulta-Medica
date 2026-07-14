package br.com.agendamento.adapters.out.persistence;

import br.com.agendamento.domain.model.AgendamentoExameJava;
import br.com.agendamento.domain.ports.out.AgendamentoExameRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AgendamentoExameRepositoryAdapter implements AgendamentoExameRepositoryPort {

    private final AgendamentoExameJpaRepository jpaRepository;

    public AgendamentoExameRepositoryAdapter(AgendamentoExameJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public AgendamentoExameJava salvar(AgendamentoExameJava entidade) {
        return jpaRepository.save(entidade);
    }

    @Override
    public Optional<AgendamentoExameJava> buscarPorId(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<AgendamentoExameJava> listarTodos() {
        return jpaRepository.findAll();
    }

    @Override
    public void deletarPorId(Long id) {
        jpaRepository.deleteById(id);
    }
}
