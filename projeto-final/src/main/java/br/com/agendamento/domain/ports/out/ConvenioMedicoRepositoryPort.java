package br.com.agendamento.domain.ports.out;

import br.com.agendamento.domain.model.ConvenioMedicoJava;

import java.util.List;
import java.util.Optional;

public interface ConvenioMedicoRepositoryPort {

    ConvenioMedicoJava salvar(ConvenioMedicoJava entidade);

    Optional<ConvenioMedicoJava> buscarPorId(Long id);

    List<ConvenioMedicoJava> listarTodos();

    void deletarPorId(Long id);
}
