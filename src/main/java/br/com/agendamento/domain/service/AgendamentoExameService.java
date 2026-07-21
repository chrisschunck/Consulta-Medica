package br.com.agendamento.domain.service;

import br.com.agendamento.domain.model.AgendamentoExameJava;
import br.com.agendamento.domain.ports.in.AgendamentoExameUseCase;
import br.com.agendamento.domain.ports.out.AgendamentoExameRepositoryPort;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Validated
@Schema(description="classe AgendamentoExame implementado UseCase para regras de negócios")
public class AgendamentoExameService implements AgendamentoExameUseCase {

    private final AgendamentoExameRepositoryPort repositoryPort;

    public AgendamentoExameService(AgendamentoExameRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public AgendamentoExameJava salvar(AgendamentoExameJava entidade) {
        return repositoryPort.salvar(entidade);
    }

    @Override
    public AgendamentoExameJava buscarPorId(Long id) {
        return repositoryPort.buscarPorId(id)
                .orElseThrow(() -> new NoSuchElementException("AgendamentoExameJava nao encontrado(a) com id: " + id));
    }

    @Override
    public List<AgendamentoExameJava> listarTodos() {
        return repositoryPort.listarTodos();
    }

    @Override
    public void deletarPorId(Long id) {
        repositoryPort.deletarPorId(id);
    }
}
