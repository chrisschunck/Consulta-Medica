package br.com.agendamento.domain.ports.in;

import br.com.agendamento.domain.model.LaboratorioHospitalJava;

import jakarta.validation.Valid;
import java.util.List;

public interface LaboratorioHospitalUseCase {

    LaboratorioHospitalJava salvar(@Valid LaboratorioHospitalJava entidade);

    LaboratorioHospitalJava buscarPorId(Long id);

    List<LaboratorioHospitalJava> listarTodos();

    void deletarPorId(Long id);
}
