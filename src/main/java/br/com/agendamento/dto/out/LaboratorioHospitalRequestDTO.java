package br.com.agendamento.dto.out;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description="Classe request dto LaboratorioHospital")
public class LaboratorioHospitalRequestDTO {

    @NotNull
    @NotBlank(message = "Nome é obrigatorio")
    private String nome;

    @NotNull
    @NotBlank(message = "Local é obrigatorio")
    private String local;

    @NotNull
    @NotBlank(message = "Descricao é obrigatorio")
    private String descricao;
}
