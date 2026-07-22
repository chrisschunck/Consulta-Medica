package br.com.agendamento.dto.out;

import br.com.agendamento.domain.model.LaboratorioHospitalJava;
import br.com.agendamento.domain.model.MedicoJava;
import br.com.agendamento.domain.model.PacienteJava;
import br.com.agendamento.domain.model.ReceitaExamesJava;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description="classe response dto AgendamentoExame")
public class AgendamentoExameResponseDTO {
    private Long id;
    @Schema(description="nome do Médico agendado", example="Cardiologista", minlenght="3", maxlenght="30")
    private MedicoJava medicoJava;
    @Schema(description="nome do Paciente agendado", example="Matheus")
    private PacienteJava pacienteJava;
    @Schema(description="horário agendado", example="14:00")
    private LocalDateTime horarioAgendado;
    @Schema(description="pedido de exames passado", example="Urina, abdomen total")
    private ReceitaExamesJava receitaExamesJava;
    @Schema(description="local de realizacao de exames", example="Hospital ALbert Eisten")
    private LaboratorioHospitalJava laboratorioHospitalJava;
}
