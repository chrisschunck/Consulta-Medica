package br.com.agendamento.dto.out;

import br.com.agendamento.domain.model.ConsultorioJava;
import br.com.agendamento.domain.model.MedicoJava;
import br.com.agendamento.domain.model.PacienteJava;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AgendamentoResponseDTO {
    private Long id;
    private MedicoJava medicoJava;
    private PacienteJava pacienteJava;
    private LocalDateTime horarioAgendado;
    private ConsultorioJava consultorioJava;
    private String descricao;
}
