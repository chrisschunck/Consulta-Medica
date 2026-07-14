package br.com.agendamento.domain;

import br.com.agendamento.domain.model.MedicoJava;
import br.com.agendamento.domain.model.Senioridade;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MedicoJavaTest {

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

    @Test
    void devePassarValidacaoComDadosValidos() {
        MedicoJava medico = new MedicoJava(
                null, "Dr. Carlos Souza", "carlos@email.com", "Cardiologia", "CRM12345", Senioridade.SENIOR);

        Set<ConstraintViolation<MedicoJava>> violacoes = validator.validate(medico);

        assertTrue(violacoes.isEmpty());
    }

    @Test
    void deveFalharQuandoCrmForVazio() {
        MedicoJava medico = new MedicoJava(
                null, "Dr. Carlos Souza", "carlos@email.com", "Cardiologia", "", Senioridade.PLENO);

        Set<ConstraintViolation<MedicoJava>> violacoes = validator.validate(medico);

        assertFalse(violacoes.isEmpty());
    }

    @Test
    void deveFalharQuandoSenioridadeForNula() {
        MedicoJava medico = new MedicoJava(
                null, "Dr. Carlos Souza", "carlos@email.com", "Cardiologia", "CRM12345", null);

        Set<ConstraintViolation<MedicoJava>> violacoes = validator.validate(medico);

        assertFalse(violacoes.isEmpty());
    }

    @Test
    void deveAceitarTodosOsValoresDeSenioridade() {
        assertEquals(Senioridade.JUNIOR, Senioridade.valueOf("JUNIOR"));
        assertEquals(Senioridade.PLENO, Senioridade.valueOf("PLENO"));
        assertEquals(Senioridade.SENIOR, Senioridade.valueOf("SENIOR"));
    }

    @Test
    void deveGerarToStringComCamposPreenchidos() {
        MedicoJava medico = new MedicoJava(
                1L, "Dr. Carlos Souza", "carlos@email.com", "Cardiologia", "CRM12345", Senioridade.JUNIOR);

        String resultado = medico.toString();

        assertTrue(resultado.contains("Dr. Carlos Souza"));
        assertTrue(resultado.contains("JUNIOR"));
    }
}
