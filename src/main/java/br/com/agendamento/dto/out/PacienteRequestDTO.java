package br.com.agendamento.dto.out;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description="Classe request dto Paciente")
public class PacienteRequestDTO {

    @NotNull
    @NotBlank(message = "Nome é obrigatorio")
    private String nome;

    @NotBlank
    @NotNull(message = "Idade é obrigatoria")
    private Integer idade;

    @NotNull
    @NotBlank(message = "Email é obrigatorio")
    private String email;

    @NotNull
    @NotBlank(message = "CPF é obrigatorio")
    private String cpf;

    @NotNull
    @NotBlank(message = "Contato é obrigatorio")
    private String contato;
}
