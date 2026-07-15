package br.com.agendamento.adapters.out.persistence;

import br.com.agendamento.domain.model.ReceitaExamesJava;
import br.com.agendamento.domain.ports.out.ReceitaExamesRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ReceitaExamesRepositoryAdapter implements ReceitaExamesRepositoryPort {

    private final ReceitaExamesJpaRepository jpaRepository;

    public ReceitaExamesRepositoryAdapter(ReceitaExamesJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public ReceitaExamesJava salvar(ReceitaExamesJava entidade) {
        return jpaRepository.save(entidade);
    }

    @Override
    public Optional<ReceitaExamesJava> buscarPorId(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<ReceitaExamesJava> listarTodos() {
        return jpaRepository.findAll();
    }

    @Override
    public void deletarPorId(Long id) {
        jpaRepository.deleteById(id);
    }
}
