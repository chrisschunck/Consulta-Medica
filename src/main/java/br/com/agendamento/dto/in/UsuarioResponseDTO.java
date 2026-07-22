package br.com.agendamento.dto.in;

import lombok.Data;

import javax.management.relation.Role;

@Data
@Schema(description="Classe response dto Usuario")
public class UsuarioResponseDTO {
    private Long id;
    @Schema(description="nome do Usuario", example="Matheus", minLength= 3, maxLength= 50)
    private String nome;
    @Schema(description="email de contato do usuario", examplo="matheus.usuario@gmail.com", minLength= 15, maxLength= 50)
    private String email;
    @Schema(description="senha para acesso do usuario", example="matheus123", minLength= 5, maxLength= 25)
    private String senha;
    private Role role;
}
