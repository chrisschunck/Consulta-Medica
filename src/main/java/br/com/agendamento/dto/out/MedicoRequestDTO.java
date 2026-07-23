package br.com.agendamento.dto.out;

import br.com.agendamento.domain.model.Senioridade;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description="Classe request dto Medico")
public class MedicoRequestDTO {

    @NotNull
    @NotEmpty
    @NotBlank(message = "Nome é obrigatorio")
    private String nome;

    @NotNull
    @NotEmpty
    @NotBlank(message = "Email é obrigatorio")
    private String email;

    @NotNull
    @NotEmpty
    @NotBlank(message = "Area de atuacao é obrigatoria")
    private String areaAtuacao;

    @NotNull
    @NotEmpty
    @NotBlank(message = "CRM é obrigatorio")
    private String crm;

    @NotBlank
    @NotEmpty
    @NotNull(message = "Senioridade é obrigatoria")
    private Senioridade senioridade;
}
