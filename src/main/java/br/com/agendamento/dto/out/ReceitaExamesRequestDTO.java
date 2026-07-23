package br.com.agendamento.dto.out;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description="Classe request dto de receita de exames")
public class ReceitaExamesRequestDTO {

    @NotNull
    @NotEmpty
    @NotBlank(message = "Exame não pode ser nulo ou vazio")
    private String exame;

    @NotNull
    @NotEmpty
    @NotBlank(message = "Descrição não pode ser nulo ou vazio")
    private String descricao;
}
