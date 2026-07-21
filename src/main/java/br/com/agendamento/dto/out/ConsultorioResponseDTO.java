package br.com.agendamento.dto.out;

import lombok.Data;

@Data
public class ConsultorioResponseDTO {
    private Long id;
    @Schema(description="nome do Consultorio", example="Cardiologia - Mooca")
    private String nome;
    @Schema(description="local de realização", example="Rua Mooca, 123")
    private String local;
}
