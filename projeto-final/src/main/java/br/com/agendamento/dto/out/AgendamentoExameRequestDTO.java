package br.com.agendamento.dto.out;

import br.com.agendamento.domain.model.LaboratorioHospitalJava;
import br.com.agendamento.domain.model.MedicoJava;
import br.com.agendamento.domain.model.PacienteJava;
import br.com.agendamento.domain.model.ReceitaExamesJava;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgendamentoExameRequestDTO {
    @NotNull
    @NotBlank(message = "Medico é obrigatorio")
    private MedicoJava medicoJava;

    @NotNull
    @NotBlank(message = "Paciente é obrigatorio")
    private PacienteJava pacienteJava;

    @NotNull
    @NotBlank(message = "Horario agendado é obrigatorio")
    private LocalDateTime horarioAgendado;

    @NotNull
    @NotBlank(message = "Receita de exames é obrigatoria")
    private ReceitaExamesJava receitaExamesJava;

    @NotNull
    @NotBlank(message = "Laboratorio/Hospital é obrigatorio")
    private LaboratorioHospitalJava laboratorioHospitalJava;
}
