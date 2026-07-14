package br.com.agendamento.dto.out;

import lombok.Data;

@Data
public class PacienteResponseDTO {

    private Long id;
    private String nome;
    private Integer idade;
    private String email;
    private String cpf;
    private String contato;
}
