package br.com.agendamento.domain.ports.out;

import br.com.agendamento.domain.model.AgendamentoExameJava;

import java.util.List;
import java.util.Optional;

@Component
@Schema(description="interface AgendamentoExame para saida em port repository")
public interface AgendamentoExameRepositoryPort {

    AgendamentoExameJava salvar(AgendamentoExameJava entidade);

    Optional<AgendamentoExameJava> buscarPorId(Long id);

    List<AgendamentoExameJava> listarTodos();

    void deletarPorId(Long id);
}
