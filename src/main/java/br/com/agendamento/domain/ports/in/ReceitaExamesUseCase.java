package br.com.agendamento.domain.ports.in;

import br.com.agendamento.domain.model.ReceitaExamesJava;

import jakarta.validation.Valid;
import java.util.List;

@Schema(description="interface ReceitaExames para casos de uso")
public interface ReceitaExamesUseCase {

    ReceitaExamesJava salvar(@Valid ReceitaExamesJava entidade);

    ReceitaExamesJava buscarPorId(Long id);

    List<ReceitaExamesJava> listarTodos();

    void deletarPorId(Long id);
}
