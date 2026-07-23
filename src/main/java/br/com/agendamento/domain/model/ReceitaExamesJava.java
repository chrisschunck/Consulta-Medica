package br.com.agendamento.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "receita_exames")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description="Classe ReceitaExames transformada em tabela como entidade")
public class ReceitaExamesJava {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique=true)
    private Long id;

    @Size(min = 2, max = 120, message = "Exame deve ter entre 2 e 120 caracteres")
    @Column(name = "exame", length = 120, nullable = false)
    private String exame;

    @Size(min = 2, max = 255, message = "Descricao deve ter entre 2 e 255 caracteres")
    @Column(name = "descricao", length = 255, nullable = false)
    private String descricao;

    @Override
    public String toString() {
        return "ReceitaExamesJava{" +
                "id=" + id +
                ", exame='" + exame + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
