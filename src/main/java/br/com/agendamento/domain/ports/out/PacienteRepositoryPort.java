package br.com.agendamento.domain.ports.out;

import br.com.agendamento.domain.model.PacienteJava;

import java.util.List;
import java.util.Optional;

public interface PacienteRepositoryPort {

    PacienteJava salvar(PacienteJava entidade);

    Optional<PacienteJava> buscarPorId(Long id);

    List<PacienteJava> listarTodos();

    void deletarPorId(Long id);
}
