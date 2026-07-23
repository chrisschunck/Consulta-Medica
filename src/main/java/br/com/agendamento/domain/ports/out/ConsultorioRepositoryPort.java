package br.com.agendamento.domain.ports.out;

import br.com.agendamento.domain.model.ConsultorioJava;

import java.util.List;
import java.util.Optional;

@Component
@Schema(description="interface Consultorio para saida em port repository")
public interface ConsultorioRepositoryPort {

    ConsultorioJava salvar(ConsultorioJava entidade);

    Optional<ConsultorioJava> buscarPorId(Long id);

    List<ConsultorioJava> listarTodos();

    void deletarPorId(Long id);
}
