package br.com.agendamento.dto.out;

import lombok.Data;

@Data
@Schema(description="Classe response dto Paciente")
public class PacienteResponseDTO {

    private Long id;
    @Schema(description="nome do Paciente", example="Matheus", minLength=)
    private String nome;
    @Schema(description="idade do Paciente em número inteiro", example="32", minLength= 1, maxLength= 3)
    private Integer idade;
    @Schema(description="email de contato do Paciente", example="matheus.paciente@gmail.com", minLength= 15, maxLength= 50)
    private String email;
    @Schema(description="cpf do paciente para cadastro", example="93293819318", minLength= 11, maxLength= 20)
    private String cpf;
    @Schema(description="Meio de contato do paciente", example="um número, email", minLength= 5, maxLength= 50)
    private String contato;
}
