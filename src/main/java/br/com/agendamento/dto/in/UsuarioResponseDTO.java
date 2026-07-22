package br.com.agendamento.dto.in;

import lombok.Data;

import javax.management.relation.Role;

@Data
@Schema(description="Classe response dto Usuario")
public class UsuarioResponseDTO {
    private Long id;
    @Schema(description="nome do Usuario", example="Matheus")
    private String nome;
    @Schema(description="email de contato do usuario", examplo="matheus.usuario@gmail.com")
    private String email;
    @Schema(description="senha para acesso do usuario", example="matheus123")
    private String senha;
    private Role role;
}
