package br.com.agendamento.dto.out;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsultorioRequestDTO {

    @NotNull
    @NotEmpty
    @NotBlank(message = "Nome é obrigatorio")
    private String nome;

    @NotNull
    @NotEmpty
    @NotBlank(message = "Local é obrigatorio")
    private String local;
}
