package br.com.agendamento.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "medico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Schema(description="classe Medico transformada em tabela como entidade")    
public class MedicoJava {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Size(min = 3, max = 120, message = "Nome deve ter entre 3 e 120 caracteres")
    @Column(name = "nome", length = 120, nullable = false)
    private String nome;

    @Email(message = "Email invalido")
    @Size(max = 150)
    @Column(name = "email", length = 150, nullable = false, unique = true)
    private String email;

    @Size(min = 3, max = 100, message = "Area de atuacao deve ter entre 3 e 100 caracteres")
    @Column(name = "area_atuacao", length = 100, nullable = false)
    private String areaAtuacao;

    @Size(min = 4, max = 20, message = "CRM deve ter entre 4 e 20 caracteres")
    @Column(name = "crm", length = 20, nullable = false, unique = true)
    private String crm;

    @Enumerated(EnumType.STRING)
    @Column(name = "senioridade", length = 20, nullable = false)
    private Senioridade senioridade;

    @Override
    public String toString() {
        return "MedicoJava{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", areaAtuacao='" + areaAtuacao + '\'' +
                ", crm='" + crm + '\'' +
                ", senioridade=" + senioridade +
                '}';
    }
}
