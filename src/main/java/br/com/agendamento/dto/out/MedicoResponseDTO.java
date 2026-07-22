package br.com.agendamento.dto.out;

import br.com.agendamento.domain.model.Senioridade;
import lombok.Data;

@Data
@Schema(description="Classe response dto Medico")
public class MedicoResponseDTO {

    private Long id;
    @Schema(description="nome do Médico", example="Doutor Alexandre", minLength= 3, maxLength= 50)
    private String nome;
    @Schema(description="email de contato do Médico", example="alexandre.cardiologia@gmail.com", minLength= 15, maxLength= 50)
    private String email;
    @Schema(description="area técnica de atuação", example="Cardiologia", minLength= 3, maxLength= 50)
    private String areaAtuacao;
    @Schema(description="crm do profissional", example="394343", minLength= 6, maxLength= 25)
    private String crm;
    @Schema(description="nivel de senioridade", example="junior/pleno/senior", minLength= 5, maxLength= 25)
    private Senioridade senioridade;
}
