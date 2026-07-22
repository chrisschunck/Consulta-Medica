package br.com.agendamento.dto.out;

import lombok.Data;

@Data
@Schema(description="Classe response dto LaboratorioMedico")
public class LaboratorioMedicoResponseDTO {

    private Long id;
    @Schema(description="nome do local", example="Hospital Albert Eisten", minLength= 5, maxLength= 50)
    private String nome;
    @Schema(description="local de realização", example="Rua Mooca, 123", minLength= 5, maxLength=50)
    private String local;
}
