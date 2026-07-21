package br.com.agendamento.domain.ports.in;

import br.com.agendamento.domain.model.AgendamentoJava;

import jakarta.validation.Valid;
import java.util.List;

@Schema(description="interface Agendamento para casos de uso")
public interface AgendamentoUseCase {

    AgendamentoJava salvar(@Valid AgendamentoJava entidade);

    AgendamentoJava buscarPorId(Long id);

    List<AgendamentoJava> listarTodos();

    void deletarPorId(Long id);
}
