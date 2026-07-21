package br.com.agendamento.dto.out;

import br.com.agendamento.domain.model.ConsultorioJava;
import br.com.agendamento.domain.model.MedicoJava;
import br.com.agendamento.domain.model.PacienteJava;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AgendamentoResponseDTO {
    private Long id;
    @Schema(description="nome do Médico agendado", example="Cardiologista")
    private MedicoJava medicoJava;
    @Schema(description="nome do Paciente agendado", example="Matheus")
    private PacienteJava pacienteJava;
    @Schema(description="horário de agendado", example="14:00")
    private LocalDateTime horarioAgendado;
    @Schema(description="local de realizacao de exames", example="Cardiologia - Mooca")
    private ConsultorioJava consultorioJava;
    @Schema(description="descritivo do agendamento" example="Exame de Urina, ir com a bexiga cheia")
    private String descricao;
}
