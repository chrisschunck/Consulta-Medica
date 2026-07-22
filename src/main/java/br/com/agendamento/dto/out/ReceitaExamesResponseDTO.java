package br.com.agendamento.dto.out;

import lombok.Data;

@Data
@Schema(description="Classe response dto de receita de exames")
public class ReceitaExamesResponseDTO {
    private Long id;
    @Schema(description="pedido de exames", example="Urina, abdomen total", minLength= 5, maxLength= 150)
    private String exame;
    @Schema(description="descritivo do pedido de exames", example="Exame de urina, ir de bexiga cheia", minLength= 6, maxLength= 150)
    private String descricao;
}
