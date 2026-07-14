package br.com.agendamento.dto.out;


import br.com.agendamento.domain.model.ConsultorioJava;
import br.com.agendamento.domain.model.MedicoJava;
import br.com.agendamento.domain.model.PacienteJava;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgendamentoRequestDTO {

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
    @NotBlank(message = "Consultorio é obrigatorio")
    private ConsultorioJava consultorioJava;

    @NotBlank
    @NotNull(message = "Descricao é obrigatorio")
    private String descricao;
}
