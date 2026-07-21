package br.com.agendamento.domain.service;

import br.com.agendamento.domain.model.LaboratorioHospitalJava;
import br.com.agendamento.domain.ports.in.LaboratorioHospitalUseCase;
import br.com.agendamento.domain.ports.out.LaboratorioHospitalRepositoryPort;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Validated
@Schema(description="classe LaboratorioHospital implementado UseCase para regras de negócios")
public class LaboratorioHospitalService implements LaboratorioHospitalUseCase {

    private final LaboratorioHospitalRepositoryPort repositoryPort;

    public LaboratorioHospitalService(LaboratorioHospitalRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public LaboratorioHospitalJava salvar(LaboratorioHospitalJava entidade) {
        return repositoryPort.salvar(entidade);
    }

    @Override
    public LaboratorioHospitalJava buscarPorId(Long id) {
        return repositoryPort.buscarPorId(id)
                .orElseThrow(() -> new NoSuchElementException("LaboratorioHospitalJava nao encontrado(a) com id: " + id));
    }

    @Override
    public List<LaboratorioHospitalJava> listarTodos() {
        return repositoryPort.listarTodos();
    }

    @Override
    public void deletarPorId(Long id) {
        repositoryPort.deletarPorId(id);
    }
}
