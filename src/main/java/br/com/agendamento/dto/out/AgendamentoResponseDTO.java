package br.com.agendamento.dto.out;

import br.com.agendamento.domain.model.ConsultorioJava;
import br.com.agendamento.domain.model.MedicoJava;
import br.com.agendamento.domain.model.PacienteJava;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description="classe response dto Agendamento")
public class AgendamentoResponseDTO {
    private Long id;
    @Schema(description="nome do Médico agendado", example="Cardiologista", minLength= 5, maxLength= 50)
    private MedicoJava medicoJava;
    @Schema(description="nome do Paciente agendado", example="Matheus", minLength= 3, maxLength= 50)
    private PacienteJava pacienteJava;
    @Schema(description="horário de agendado", example="14:00", minLength= 4, maxLength= 5)
    private LocalDateTime horarioAgendado;
    @Schema(description="local de realizacao de exames", example="Cardiologia - Mooca", minLength= 5, maxLength= 50)
    private ConsultorioJava consultorioJava;
    @Schema(description="descritivo do agendamento" example="Exame de Urina, ir com a bexiga cheia", minLength= 5, maxLength= 150)
    private String descricao;
}
