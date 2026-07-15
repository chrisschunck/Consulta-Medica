package br.com.agendamento.dto.in;

import lombok.Data;

import javax.management.relation.Role;

@Data
public class UsuarioResponseDTO {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private Role role;
}
