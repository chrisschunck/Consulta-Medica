package br.com.agendamento.dto.out;

import lombok.Data;

@Data
public class ReceitaExamesResponseDTO {
    private Long id;
    private String exame;
    private String descricao;
}
