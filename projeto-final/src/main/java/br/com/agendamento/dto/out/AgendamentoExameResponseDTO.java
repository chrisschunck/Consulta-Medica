package br.com.agendamento.dto.out;

import br.com.agendamento.domain.model.LaboratorioHospitalJava;
import br.com.agendamento.domain.model.MedicoJava;
import br.com.agendamento.domain.model.PacienteJava;
import br.com.agendamento.domain.model.ReceitaExamesJava;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AgendamentoExameResponseDTO {
    private Long id;
    private MedicoJava medicoJava;
    private PacienteJava pacienteJava;
    private LocalDateTime horarioAgendado;
    private ReceitaExamesJava receitaExamesJava;
    private LaboratorioHospitalJava laboratorioHospitalJava;
}
