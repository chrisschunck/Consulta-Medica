package br.com.agendamento.domain.ports.in;

import br.com.agendamento.domain.model.MedicoJava;

import jakarta.validation.Valid;
import java.util.List;

@Schema(description="interface Medico para casos de uso")
public interface MedicoUseCase {

    MedicoJava salvar(@Valid MedicoJava entidade);

    MedicoJava buscarPorId(Long id);

    List<MedicoJava> listarTodos();

    void deletarPorId(Long id);
}
