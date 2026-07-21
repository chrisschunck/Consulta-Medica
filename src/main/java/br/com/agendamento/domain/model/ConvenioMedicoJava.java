package br.com.agendamento.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "convenio_medico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description="classe ConvenioMedico transformada em tabela como entidade")
public class ConvenioMedicoJava {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Size(min = 2, max = 100, message = "Marca deve ter entre 2 e 100 caracteres")
    @Column(name = "marca", length = 100, nullable = false)
    private String marca;

    @Positive(message = "Valor deve ser positivo")
    @Column(name = "valor", nullable = false)
    private BigDecimal valor;

    @Override
    public String toString() {
        return "ConvenioMedicoJava{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", valor=" + valor +
                '}';
    }
}
