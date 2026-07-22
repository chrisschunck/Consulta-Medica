package br.com.agendamento.security.dto;

import jakarta.validation.constraints.*;

@Schema(description="classe resquest e response dto Auth")
public class AuthDTO {

    @Schema(description="record request dto Login")
    public record LoginRequest(
        @NotBlank(message = "Email e obrigatorio") @Email @Schema(description="email para login do usuario", example="matheus.usuario@gmail.com") String email,
        @NotBlank(message = "Senha e obrigatoria") @Schema(description="senha para login do usuario", example="matheus123") String senha
    ) {}

    @Schema(description="record request dto Registro")
    public record RegistroRequest(
        @NotBlank @Size(min = 3, max = 120) @Schema(description="nome completo do usuario", example="Matheus Henrique de Souza") String nome,
        @NotBlank @Email @Schema(description="email de contato", example="matheus.usuario@gmail.com") String email,
        @NotBlank @Size(min = 6, message = "Senha deve ter no minimo 6 caracteres") String senha,
        @NotBlank String role
    ) {}

    @Schema(description="record response dto Token")
    public record TokenResponse(String token, String tipo, String email, String role) {}
}
