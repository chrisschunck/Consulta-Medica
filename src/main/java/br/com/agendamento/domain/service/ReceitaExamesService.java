package br.com.agendamento.domain.service;

import br.com.agendamento.domain.model.ReceitaExamesJava;
import br.com.agendamento.domain.ports.in.ReceitaExamesUseCase;
import br.com.agendamento.domain.ports.out.ReceitaExamesRepositoryPort;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Validated
@Component
@Schema(description="classe ReceitaExames implementado UseCase para regras de negócios")
public class ReceitaExamesService implements ReceitaExamesUseCase {

    private final ReceitaExamesRepositoryPort repositoryPort;

    public ReceitaExamesService(ReceitaExamesRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public ReceitaExamesJava salvar(ReceitaExamesJava entidade) {
        return repositoryPort.salvar(entidade);
    }

    @Override
    public ReceitaExamesJava buscarPorId(Long id) {
        return repositoryPort.buscarPorId(id)
                .orElseThrow(() -> new NoSuchElementException("ReceitaExamesJava nao encontrado(a) com id: " + id));
    }

    @Override
    public List<ReceitaExamesJava> listarTodos() {
        return repositoryPort.listarTodos();
    }

    @Override
    public void deletarPorId(Long id) {
        repositoryPort.deletarPorId(id);
    }
}
