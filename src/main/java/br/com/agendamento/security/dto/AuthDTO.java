package br.com.agendamento.security.dto;

import jakarta.validation.constraints.*;

public class AuthDTO {

    public record LoginRequest(
        @NotBlank(message = "Email e obrigatorio") @Email String email,
        @NotBlank(message = "Senha e obrigatoria") String senha
    ) {}

    public record RegistroRequest(
        @NotBlank @Size(min = 3, max = 120) String nome,
        @NotBlank @Email String email,
        @NotBlank @Size(min = 6, message = "Senha deve ter no minimo 6 caracteres") String senha,
        @NotBlank String role
    ) {}

    public record TokenResponse(String token, String tipo, String email, String role) {}
}
