package br.com.agendamento.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "usuario")
@Getter
@Setter 
@NoArgsConstructor 
@AllArgsConstructor
@Schema(description="classe Usuario transformada em tabela como entidade")
public class UsuarioJava {

    public enum Role { ADMIN, RECEPCIONISTA, MEDICO }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique=true)
    private Long id;

    @Size(min = 3, max = 120)
    @Column(name = "nome", length = 120, nullable = false)
    private String nome;

    @Email
    @Column(name = "email", length = 50, nullable = false, unique = true)
    private String email;

    @Column(name = "senha", length = 25, nullable = false)
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", length = 20, nullable = false)
    private Role role;

    @Override
    public String toString() {
        return "UsuarioJava{id=" + id + ", nome='" + nome + "', email='" + email + "', role=" + role + '}';
    }
}
