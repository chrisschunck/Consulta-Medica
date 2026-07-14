package br.com.agendamento.domain.ports.in;

import br.com.agendamento.domain.model.ReceitaExamesJava;

import jakarta.validation.Valid;
import java.util.List;

public interface ReceitaExamesUseCase {

    ReceitaExamesJava salvar(@Valid ReceitaExamesJava entidade);

    ReceitaExamesJava buscarPorId(Long id);

    List<ReceitaExamesJava> listarTodos();

    void deletarPorId(Long id);
}
