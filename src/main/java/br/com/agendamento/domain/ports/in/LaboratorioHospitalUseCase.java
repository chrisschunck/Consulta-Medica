package br.com.agendamento.domain.ports.in;

import br.com.agendamento.domain.model.LaboratorioHospitalJava;

import jakarta.validation.Valid;
import java.util.List;

@Schema(description="interface LaboratorioHospital para casos de uso")
public interface LaboratorioHospitalUseCase {

    LaboratorioHospitalJava salvar(@Valid LaboratorioHospitalJava entidade);

    LaboratorioHospitalJava buscarPorId(Long id);

    List<LaboratorioHospitalJava> listarTodos();

    void deletarPorId(Long id);
}
