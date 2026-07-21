package br.com.agendamento.adapters.out.persistence;

import br.com.agendamento.domain.model.MedicoJava;
import br.com.agendamento.domain.ports.out.MedicoRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Schema(description="classe MedicoRepository para repository adapter")
public class MedicoRepositoryAdapter implements MedicoRepositoryPort {

    private final MedicoJpaRepository jpaRepository;

    public MedicoRepositoryAdapter(MedicoJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public MedicoJava salvar(MedicoJava entidade) {
        return jpaRepository.save(entidade);
    }

    @Override
    public Optional<MedicoJava> buscarPorId(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<MedicoJava> listarTodos() {
        return jpaRepository.findAll();
    }

    @Override
    public void deletarPorId(Long id) {
        jpaRepository.deleteById(id);
    }
}
