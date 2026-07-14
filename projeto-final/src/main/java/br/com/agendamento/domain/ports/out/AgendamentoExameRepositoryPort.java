package br.com.agendamento.domain.ports.out;

import br.com.agendamento.domain.model.AgendamentoExameJava;

import java.util.List;
import java.util.Optional;

public interface AgendamentoExameRepositoryPort {

    AgendamentoExameJava salvar(AgendamentoExameJava entidade);

    Optional<AgendamentoExameJava> buscarPorId(Long id);

    List<AgendamentoExameJava> listarTodos();

    void deletarPorId(Long id);
}
