package br.com.agendamento.domain.service;

import br.com.agendamento.domain.model.MedicoJava;
import br.com.agendamento.domain.ports.in.MedicoUseCase;
import br.com.agendamento.domain.ports.out.MedicoRepositoryPort;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Validated
public class MedicoService implements MedicoUseCase {

    private final MedicoRepositoryPort repositoryPort;

    public MedicoService(MedicoRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public MedicoJava salvar(MedicoJava entidade) {
        return repositoryPort.salvar(entidade);
    }

    @Override
    public MedicoJava buscarPorId(Long id) {
        return repositoryPort.buscarPorId(id)
                .orElseThrow(() -> new NoSuchElementException("MedicoJava nao encontrado(a) com id: " + id));
    }

    @Override
    public List<MedicoJava> listarTodos() {
        return repositoryPort.listarTodos();
    }

    @Override
    public void deletarPorId(Long id) {
        repositoryPort.deletarPorId(id);
    }
}
