package br.com.agendamento.dto.out;

import br.com.agendamento.domain.model.Senioridade;
import lombok.Data;

@Data
public class MedicoResponseDTO {

    private Long id;
    @Schema(description="nome do Médico", example="Doutor Alexandre")
    private String nome;
    @Schema(description="email de contato do Médico", example="alexandre.cardiologia@gmail.com")
    private String email;
    @Schema(description="area técnica de atuação", example="Cardiologia")
    private String areaAtuacao;
    @Schema(description="crm do profissional", example="394343")
    private String crm;
    @Schema(description="nivel de senioridade", example="junior/pleno/senior")
    private Senioridade senioridade;
}
