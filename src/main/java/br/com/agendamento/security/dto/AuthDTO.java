package br.com.agendamento.security.dto;

import jakarta.validation.constraints.*;

@Schema(description="classe resquest e response dto Auth")
public class AuthDTO {

    @Schema(description="record request dto Login")
    public record LoginRequest(
        @NotBlank(message = "Email e obrigatorio") @Email String email,
        @NotBlank(message = "Senha e obrigatoria") String senha
    ) {}

    @Schema(description="record request dto Registro")
    public record RegistroRequest(
        @NotBlank @Size(min = 3, max = 120) String nome,
        @NotBlank @Email String email,
        @NotBlank @Size(min = 6, message = "Senha deve ter no minimo 6 caracteres") String senha,
        @NotBlank String role
    ) {}

    @Schema(description="record response dto Token")
    public record TokenResponse(String token, String tipo, String email, String role) {}
}
