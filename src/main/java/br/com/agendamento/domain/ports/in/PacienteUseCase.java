package br.com.agendamento.domain.ports.in;

import br.com.agendamento.domain.model.PacienteJava;

import jakarta.validation.Valid;
import java.util.List;

@Component
@Schema(description="classe Paciente para casos de uso")
public interface PacienteUseCase {

    PacienteJava salvar(@Valid PacienteJava entidade);

    PacienteJava buscarPorId(Long id);

    List<PacienteJava> listarTodos();

    void deletarPorId(Long id);
}
