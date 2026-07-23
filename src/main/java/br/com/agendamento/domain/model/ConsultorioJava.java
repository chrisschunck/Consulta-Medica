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
@Table(name = "consultorio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description="classe Consultorio transformada em tabela como entidade")
public class ConsultorioJava {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Size(min = 2, max = 100, message = "Nome deve ter entre 2 e 100 caracteres")
    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Size(min = 2, max = 150, message = "Local deve ter entre 2 e 150 caracteres")
    @Column(name = "local", length = 150, nullable = false)
    private String local;

    @Override
    public String toString() {
        return "ConsultorioJava{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", local='" + local + '\'' +
                '}';
    }
}
