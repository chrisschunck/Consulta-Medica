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
@Table(name = "laboratorio_hospital")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description="classe LaboratorioHospital transformada em tabela como entidade")
public class LaboratorioHospitalJava {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique=true)
    private Long id;

    @Size(min = 2, max = 150, message = "Nome deve ter entre 2 e 150 caracteres")
    @Column(name = "nome", length = 150, nullable = false)
    private String nome;

    @Size(min = 2, max = 150, message = "Local deve ter entre 2 e 150 caracteres")
    @Column(name = "local", length = 150, nullable = false)
    private String local;

    @Size(min = 2, max = 255, message = "Descricao deve ter entre 2 e 255 caracteres")
    @Column(name = "descricao", length = 255, nullable = false)
    private String descricao;

    @Override
    public String toString() {
        return "LaboratorioHospitalJava{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", local='" + local + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
