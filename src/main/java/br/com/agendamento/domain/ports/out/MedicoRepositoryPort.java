package br.com.agendamento.domain.ports.out;

import br.com.agendamento.domain.model.MedicoJava;

import java.util.List;
import java.util.Optional;

public interface MedicoRepositoryPort {

    MedicoJava salvar(MedicoJava entidade);

    Optional<MedicoJava> buscarPorId(Long id);

    List<MedicoJava> listarTodos();

    void deletarPorId(Long id);
}
