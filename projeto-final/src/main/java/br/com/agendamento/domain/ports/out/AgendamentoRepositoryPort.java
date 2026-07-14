package br.com.agendamento.domain.ports.out;

import br.com.agendamento.domain.model.AgendamentoJava;

import java.util.List;
import java.util.Optional;

public interface AgendamentoRepositoryPort {

    AgendamentoJava salvar(AgendamentoJava entidade);

    Optional<AgendamentoJava> buscarPorId(Long id);

    List<AgendamentoJava> listarTodos();

    void deletarPorId(Long id);
}
