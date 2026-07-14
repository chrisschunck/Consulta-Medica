package br.com.agendamento.dto.out;

import br.com.agendamento.domain.model.Senioridade;
import lombok.Data;

@Data
public class MedicoResponseDTO {

    private Long id;
    private String nome;
    private String email;
    private String areaAtuacao;
    private String crm;
    private Senioridade senioridade;
}
