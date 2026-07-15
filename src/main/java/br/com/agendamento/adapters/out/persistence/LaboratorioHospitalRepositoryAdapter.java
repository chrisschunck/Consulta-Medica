package br.com.agendamento.adapters.out.persistence;

import br.com.agendamento.domain.model.LaboratorioHospitalJava;
import br.com.agendamento.domain.ports.out.LaboratorioHospitalRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class LaboratorioHospitalRepositoryAdapter implements LaboratorioHospitalRepositoryPort {

    private final LaboratorioHospitalJpaRepository jpaRepository;

    public LaboratorioHospitalRepositoryAdapter(LaboratorioHospitalJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public LaboratorioHospitalJava salvar(LaboratorioHospitalJava entidade) {
        return jpaRepository.save(entidade);
    }

    @Override
    public Optional<LaboratorioHospitalJava> buscarPorId(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<LaboratorioHospitalJava> listarTodos() {
        return jpaRepository.findAll();
    }

    @Override
    public void deletarPorId(Long id) {
        jpaRepository.deleteById(id);
    }
}
