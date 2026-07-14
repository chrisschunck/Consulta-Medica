package br.com.agendamento.domain.ports.out;

import br.com.agendamento.domain.model.ReceitaExamesJava;

import java.util.List;
import java.util.Optional;

public interface ReceitaExamesRepositoryPort {

    ReceitaExamesJava salvar(ReceitaExamesJava entidade);

    Optional<ReceitaExamesJava> buscarPorId(Long id);

    List<ReceitaExamesJava> listarTodos();

    void deletarPorId(Long id);
}
