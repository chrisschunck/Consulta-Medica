package br.com.agendamento.adapters.out.persistence;

import br.com.agendamento.domain.model.AgendamentoJava;
import br.com.agendamento.domain.ports.out.AgendamentoRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AgendamentoRepositoryAdapter implements AgendamentoRepositoryPort {

    private final AgendamentoJpaRepository jpaRepository;

    public AgendamentoRepositoryAdapter(AgendamentoJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public AgendamentoJava salvar(AgendamentoJava entidade) {
        return jpaRepository.save(entidade);
    }

    @Override
    public Optional<AgendamentoJava> buscarPorId(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<AgendamentoJava> listarTodos() {
        return jpaRepository.findAll();
    }

    @Override
    public void deletarPorId(Long id) {
        jpaRepository.deleteById(id);
    }
}
