package br.com.agendamento.domain.service;

import br.com.agendamento.domain.model.AgendamentoJava;
import br.com.agendamento.domain.ports.in.AgendamentoUseCase;
import br.com.agendamento.domain.ports.out.AgendamentoRepositoryPort;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Validated
@Component
@Schema(description="classe Agendamento implementado UseCase para regras de negócios")
public class AgendamentoService implements AgendamentoUseCase {

    private final AgendamentoRepositoryPort repositoryPort;

    public AgendamentoService(AgendamentoRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public AgendamentoJava salvar(AgendamentoJava entidade) {
        return repositoryPort.salvar(entidade);
    }

    @Override
    public AgendamentoJava buscarPorId(Long id) {
        return repositoryPort.buscarPorId(id)
                .orElseThrow(() -> new NoSuchElementException("AgendamentoJava nao encontrado(a) com id: " + id));
    }

    @Override
    public List<AgendamentoJava> listarTodos() {
        return repositoryPort.listarTodos();
    }

    @Override
    public void deletarPorId(Long id) {
        repositoryPort.deletarPorId(id);
    }
}
