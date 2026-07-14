package br.com.agendamento.domain.service;

import br.com.agendamento.domain.model.ConvenioMedicoJava;
import br.com.agendamento.domain.ports.in.ConvenioMedicoUseCase;
import br.com.agendamento.domain.ports.out.ConvenioMedicoRepositoryPort;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Validated
public class ConvenioMedicoService implements ConvenioMedicoUseCase {

    private final ConvenioMedicoRepositoryPort repositoryPort;

    public ConvenioMedicoService(ConvenioMedicoRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public ConvenioMedicoJava salvar(ConvenioMedicoJava entidade) {
        return repositoryPort.salvar(entidade);
    }

    @Override
    public ConvenioMedicoJava buscarPorId(Long id) {
        return repositoryPort.buscarPorId(id)
                .orElseThrow(() -> new NoSuchElementException("ConvenioMedicoJava nao encontrado(a) com id: " + id));
    }

    @Override
    public List<ConvenioMedicoJava> listarTodos() {
        return repositoryPort.listarTodos();
    }

    @Override
    public void deletarPorId(Long id) {
        repositoryPort.deletarPorId(id);
    }
}
