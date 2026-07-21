package br.com.agendamento.domain.ports.in;

import br.com.agendamento.domain.model.AgendamentoExameJava;

import jakarta.validation.Valid;
import java.util.List;

@Schema(description="interface AgendamentoExame para casos de uso")
public interface AgendamentoExameUseCase {

    AgendamentoExameJava salvar(@Valid AgendamentoExameJava entidade);

    AgendamentoExameJava buscarPorId(Long id);

    List<AgendamentoExameJava> listarTodos();

    void deletarPorId(Long id);
}
