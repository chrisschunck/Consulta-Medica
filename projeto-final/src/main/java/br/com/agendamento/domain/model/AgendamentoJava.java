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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
@Table(name = "agendamento")
public class AgendamentoJava {

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "convenio_medico_id")
    private ConvenioMedicoJava convenioMedico;

    @Column(name = "horario_agendado", nullable = false)
    private LocalDateTime horarioAgendado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consultorio_id", nullable = false)
    private ConsultorioJava consultorio;

    @Size(min = 2, max = 255, message = "Descricao deve ter entre 2 e 255 caracteres")
    @Column(name = "descricao", length = 255, nullable = false)
    private String descricao;

    public AgendamentoJava() {}

    public AgendamentoJava(Long id, MedicoJava medico, PacienteJava paciente,
                           ConvenioMedicoJava convenioMedico, LocalDateTime horarioAgendado,
                           ConsultorioJava consultorio, String descricao) {
        this.id = id;
        this.medico = medico;
        this.paciente = paciente;
        this.convenioMedico = convenioMedico;
        this.horarioAgendado = horarioAgendado;
        this.consultorio = consultorio;
        this.descricao = descricao;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public MedicoJava getMedico() { return medico; }
    public void setMedico(MedicoJava medico) { this.medico = medico; }

    public PacienteJava getPaciente() { return paciente; }
    public void setPaciente(PacienteJava paciente) { this.paciente = paciente; }

    public ConvenioMedicoJava getConvenioMedico() { return convenioMedico; }
    public void setConvenioMedico(ConvenioMedicoJava convenioMedico) { this.convenioMedico = convenioMedico; }

    public LocalDateTime getHorarioAgendado() { return horarioAgendado; }
    public void setHorarioAgendado(LocalDateTime horarioAgendado) { this.horarioAgendado = horarioAgendado; }

    public ConsultorioJava getConsultorio() { return consultorio; }
    public void setConsultorio(ConsultorioJava consultorio) { this.consultorio = consultorio; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    @Override
    public String toString() {
        return "AgendamentoJava{" +
                "id=" + id +
                ", medico=" + medico +
                ", paciente=" + paciente +
                ", horarioAgendado=" + horarioAgendado +
                ", consultorio=" + consultorio +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}