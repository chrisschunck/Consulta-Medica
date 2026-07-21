package br.com.agendamento.domain.service;

import br.com.agendamento.domain.model.PacienteJava;
import br.com.agendamento.domain.ports.in.PacienteUseCase;
import br.com.agendamento.domain.ports.out.PacienteRepositoryPort;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Validated
@Schema(description="classe Paciente implementado UseCase para regras de negócios")
public class PacienteService implements PacienteUseCase {

    private final PacienteRepositoryPort repositoryPort;

    public PacienteService(PacienteRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public PacienteJava salvar(PacienteJava entidade) {
        return repositoryPort.salvar(entidade);
    }

    @Override
    public PacienteJava buscarPorId(Long id) {
        return repositoryPort.buscarPorId(id)
                .orElseThrow(() -> new NoSuchElementException("PacienteJava nao encontrado(a) com id: " + id));
    }

    @Override
    public List<PacienteJava> listarTodos() {
        return repositoryPort.listarTodos();
    }

    @Override
    public void deletarPorId(Long id) {
        repositoryPort.deletarPorId(id);
    }
}
