package br.com.agendamento.domain.ports.out;

import br.com.agendamento.domain.model.LaboratorioHospitalJava;

import java.util.List;
import java.util.Optional;

@Component
@Schema(description="interface LaboratorioHospital para saida em port repository")
public interface LaboratorioHospitalRepositoryPort {

    LaboratorioHospitalJava salvar(LaboratorioHospitalJava entidade);

    Optional<LaboratorioHospitalJava> buscarPorId(Long id);

    List<LaboratorioHospitalJava> listarTodos();

    void deletarPorId(Long id);
}
