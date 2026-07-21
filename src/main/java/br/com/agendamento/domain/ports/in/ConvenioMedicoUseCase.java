package br.com.agendamento.domain.ports.in;

import br.com.agendamento.domain.model.ConvenioMedicoJava;

import jakarta.validation.Valid;
import java.util.List;

@Schema(description="interface ConvenioMedico para casos de uso")
public interface ConvenioMedicoUseCase {

    ConvenioMedicoJava salvar(@Valid ConvenioMedicoJava entidade);

    ConvenioMedicoJava buscarPorId(Long id);

    List<ConvenioMedicoJava> listarTodos();

    void deletarPorId(Long id);
}
