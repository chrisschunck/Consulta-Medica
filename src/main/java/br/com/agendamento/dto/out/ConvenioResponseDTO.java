package br.com.agendamento.dto.out;

import lombok.Data;

@Data
public class ConvenioResponseDTO {
    private Long id;
    @Schema(description="marca do plano de saúde", example="Porto Seguro", minLength= 5, maxLength= 25)
    private String marca;
    @Schema(description="valor mensalidade", example="1.399", minLength= 3, maxLength= 10)
    private String valor;
}
