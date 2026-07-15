package br.com.agendamento.dto.out;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConvenioMedicoRequestDTO {

    @NotNull
    @NotBlank(message = "Marca é obrigatoria")
    private String marca;

    @NotBlank
    @NotNull(message = "Valor é obrigatorio")
    private BigDecimal valor;
}
