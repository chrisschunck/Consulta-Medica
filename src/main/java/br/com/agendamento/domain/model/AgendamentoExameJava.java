package br.com.agendamento.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "agendamento_exame")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AgendamentoExameJava {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id", nullable = false)
    private MedicoJava medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id", nullable = false)
    private PacienteJava paciente;

    @Column(name = "horario_agendado", nullable = false)
    private LocalDateTime horarioAgendado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receita_exames_id", nullable = false)
    private ReceitaExamesJava receitaExames;

    /** Pode representar Consultorio, Laboratorio ou Hospital onde o exame sera realizado. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "laboratorio_hospital_id", nullable = false)
    private LaboratorioHospitalJava laboratorioHospital;

    @Override
    public String toString() {
        return "AgendamentoExameJava{" +
                "id=" + id +
                ", medico=" + medico +
                ", paciente=" + paciente +
                ", horarioAgendado=" + horarioAgendado +
                ", receitaExames=" + receitaExames +
                ", laboratorioHospital=" + laboratorioHospital +
                '}';
    }
}
