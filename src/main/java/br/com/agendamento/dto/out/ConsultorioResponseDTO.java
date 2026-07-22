package br.com.agendamento.dto.out;

import lombok.Data;

@Data
@Schema(description="classe response dto Consultorio")
public class ConsultorioResponseDTO {
    private Long id;
    @Schema(description="nome do Consultorio", example="Cardiologia - Mooca", minLength= 5, maxLength= 50)
    private String nome;
    @Schema(description="local de realização", example="Rua Mooca, 123", minLength= 5, maxLength= 50)
    private String local;
}
