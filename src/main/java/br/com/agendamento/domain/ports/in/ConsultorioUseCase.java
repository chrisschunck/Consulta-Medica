package br.com.agendamento.domain.ports.in;

import br.com.agendamento.domain.model.ConsultorioJava;

import jakarta.validation.Valid;
import java.util.List;

public interface ConsultorioUseCase {

    ConsultorioJava salvar(@Valid ConsultorioJava entidade);

    ConsultorioJava buscarPorId(Long id);

    List<ConsultorioJava> listarTodos();

    void deletarPorId(Long id);
}
