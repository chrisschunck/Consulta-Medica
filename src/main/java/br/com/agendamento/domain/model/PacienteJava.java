package br.com.agendamento.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "paciente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description="classe Paciente transformada em tabela como entidade")
public class PacienteJava {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique=true)
    private Long id;

    @Size(min = 3, max = 120, message = "Nome deve ter entre 3 e 120 caracteres")
    @Column(name = "nome", length = 120, nullable = false)
    private String nome;

    @Min(value = 0, message = "Idade nao pode ser negativa")
    @Max(value = 130, message = "Idade invalida")
    @Column(name = "idade", nullable = false)
    private Integer idade;

    @Email(message = "Email invalido")
    @Size(max = 150)
    @Column(name = "email", length = 150, nullable = false, unique = true)
    private String email;

    @Size(min = 11, max = 14, message = "CPF deve ter entre 11 e 14 caracteres")
    @Column(name = "cpf", length = 14, nullable = false, unique = true)
    private String cpf;

    @Size(min = 8, max = 20, message = "Contato deve ter entre 8 e 20 caracteres")
    @Column(name = "contato", length = 20, nullable = false)
    private String contato;

    @Override
    public String toString() {
        return "PacienteJava{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", contato='" + contato + '\'' +
                '}';
    }
}
