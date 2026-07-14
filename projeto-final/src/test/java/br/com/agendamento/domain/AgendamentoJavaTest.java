package br.com.agendamento.domain;

import br.com.agendamento.domain.model.AgendamentoJava;
import br.com.agendamento.domain.model.ConsultorioJava;
import br.com.agendamento.domain.model.MedicoJava;
import br.com.agendamento.domain.model.PacienteJava;
import br.com.agendamento.domain.model.Senioridade;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AgendamentoJavaTest {

    private static ValidatorFactory factory;
    private static Validator validator;

    @BeforeAll
    static void setUp() {
        factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @AfterAll
    static void tearDown() {
        factory.close();
    }

    private MedicoJava criarMedicoValido() {
        return new MedicoJava(1L, "Dr. Carlos Souza", "carlos@email.com", "Cardiologia", "CRM12345", Senioridade.SENIOR);
    }

    private PacienteJava criarPacienteValido() {
        return new PacienteJava(1L, "Maria da Silva", 30, "maria@email.com", "12345678901", "11999999999");
    }

    private ConsultorioJava criarConsultorioValido() {
        return new ConsultorioJava(1L, "Consultorio 101", "Bloco A - 1 andar");
    }

    @Test
    void devePassarValidacaoComDadosValidos() {
        AgendamentoJava agendamento = new AgendamentoJava(
                null, criarMedicoValido(), criarPacienteValido(), null,
                LocalDateTime.now().plusDays(1), criarConsultorioValido(), "Consulta de rotina");

        Set<ConstraintViolation<AgendamentoJava>> violacoes = validator.validate(agendamento);

        assertTrue(violacoes.isEmpty());
    }

    @Test
    void deveFalharQuandoMedicoForNulo() {
        AgendamentoJava agendamento = new AgendamentoJava(
                null, null, criarPacienteValido(), null,
                LocalDateTime.now().plusDays(1), criarConsultorioValido(), "Consulta de rotina");

        Set<ConstraintViolation<AgendamentoJava>> violacoes = validator.validate(agendamento);

        assertFalse(violacoes.isEmpty());
    }

    @Test
    void deveFalharQuandoDescricaoForVazia() {
        AgendamentoJava agendamento = new AgendamentoJava(
                null, criarMedicoValido(), criarPacienteValido(), null,
                LocalDateTime.now().plusDays(1), criarConsultorioValido(), "");

        Set<ConstraintViolation<AgendamentoJava>> violacoes = validator.validate(agendamento);

        assertFalse(violacoes.isEmpty());
    }

    @Test
    void deveFalharQuandoHorarioAgendadoForNulo() {
        AgendamentoJava agendamento = new AgendamentoJava(
                null, criarMedicoValido(), criarPacienteValido(), null,
                null, criarConsultorioValido(), "Consulta de rotina");

        Set<ConstraintViolation<AgendamentoJava>> violacoes = validator.validate(agendamento);

        assertFalse(violacoes.isEmpty());
    }
}
