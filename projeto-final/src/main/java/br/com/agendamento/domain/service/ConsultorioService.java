package br.com.agendamento.domain.service;

import br.com.agendamento.domain.model.ConsultorioJava;
import br.com.agendamento.domain.ports.in.ConsultorioUseCase;
import br.com.agendamento.domain.ports.out.ConsultorioRepositoryPort;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Validated
public class ConsultorioService implements ConsultorioUseCase {

    private final ConsultorioRepositoryPort repositoryPort;

    public ConsultorioService(ConsultorioRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public ConsultorioJava salvar(ConsultorioJava entidade) {
        return repositoryPort.salvar(entidade);
    }

    @Override
    public ConsultorioJava buscarPorId(Long id) {
        return repositoryPort.buscarPorId(id)
                .orElseThrow(() -> new NoSuchElementException("ConsultorioJava nao encontrado(a) com id: " + id));
    }

    @Override
    public List<ConsultorioJava> listarTodos() {
        return repositoryPort.listarTodos();
    }

    @Override
    public void deletarPorId(Long id) {
        repositoryPort.deletarPorId(id);
    }
}
