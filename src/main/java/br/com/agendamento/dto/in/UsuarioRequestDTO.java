package br.com.agendamento.dto.in;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.relation.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description="Classe request dto Usuario")
public class UsuarioRequestDTO {

    @NotNull
    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank
    private String email;

    @NotBlank
    private String senha;

    private Role role;
}
