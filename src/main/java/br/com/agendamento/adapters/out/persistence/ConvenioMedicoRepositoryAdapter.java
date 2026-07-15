package br.com.agendamento.adapters.out.persistence;

import br.com.agendamento.domain.model.ConvenioMedicoJava;
import br.com.agendamento.domain.ports.out.ConvenioMedicoRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ConvenioMedicoRepositoryAdapter implements ConvenioMedicoRepositoryPort {

    private final ConvenioMedicoJpaRepository jpaRepository;

    public ConvenioMedicoRepositoryAdapter(ConvenioMedicoJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public ConvenioMedicoJava salvar(ConvenioMedicoJava entidade) {
        return jpaRepository.save(entidade);
    }

    @Override
    public Optional<ConvenioMedicoJava> buscarPorId(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<ConvenioMedicoJava> listarTodos() {
        return jpaRepository.findAll();
    }

    @Override
    public void deletarPorId(Long id) {
        jpaRepository.deleteById(id);
    }
}
