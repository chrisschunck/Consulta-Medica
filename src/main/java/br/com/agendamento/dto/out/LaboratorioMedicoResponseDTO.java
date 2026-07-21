package br.com.agendamento.dto.out;

import lombok.Data;

@Data
public class LaboratorioMedicoResponseDTO {

    private Long id;
    @Schema(description="nome do local", example="Hospital Albert Eisten")
    private String nome;
    @Schema(description="local de realização", example="Rua Mooca, 123")
    private String local;
}
