package br.com.agendamento.domain;

import br.com.agendamento.domain.model.PacienteJava;
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

class PacienteJavaTest {

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
        PacienteJava paciente = new PacienteJava(
                null, "Maria da Silva", 30, "maria@email.com", "12345678901", "11999999999");

        Set<ConstraintViolation<PacienteJava>> violacoes = validator.validate(paciente);

        assertTrue(violacoes.isEmpty());
    }

    @Test
    void deveFalharQuandoNomeForVazio() {
        PacienteJava paciente = new PacienteJava(
                null, "", 30, "maria@email.com", "12345678901", "11999999999");

        Set<ConstraintViolation<PacienteJava>> violacoes = validator.validate(paciente);

        assertFalse(violacoes.isEmpty());
    }

    @Test
    void deveFalharQuandoEmailForInvalido() {
        PacienteJava paciente = new PacienteJava(
                null, "Maria da Silva", 30, "email-invalido", "12345678901", "11999999999");

        Set<ConstraintViolation<PacienteJava>> violacoes = validator.validate(paciente);

        assertFalse(violacoes.isEmpty());
    }

    @Test
    void deveFalharQuandoIdadeForNegativa() {
        PacienteJava paciente = new PacienteJava(
                null, "Maria da Silva", -1, "maria@email.com", "12345678901", "11999999999");

        Set<ConstraintViolation<PacienteJava>> violacoes = validator.validate(paciente);

        assertFalse(violacoes.isEmpty());
    }

    @Test
    void deveFalharQuandoCpfForMuitoCurto() {
        PacienteJava paciente = new PacienteJava(
                null, "Maria da Silva", 30, "maria@email.com", "123", "11999999999");

        Set<ConstraintViolation<PacienteJava>> violacoes = validator.validate(paciente);

        assertFalse(violacoes.isEmpty());
    }

    @Test
    void deveGerarToStringComCamposPreenchidos() {
        PacienteJava paciente = new PacienteJava(
                1L, "Maria da Silva", 30, "maria@email.com", "12345678901", "11999999999");

        String resultado = paciente.toString();

        assertTrue(resultado.contains("Maria da Silva"));
        assertTrue(resultado.contains("maria@email.com"));
    }

    @Test
    void devePermitirAlterarAtributosViaSetters() {
        PacienteJava paciente = new PacienteJava();
        paciente.setNome("Joao Pereira");
        paciente.setIdade(45);
        paciente.setEmail("joao@email.com");
        paciente.setCpf("98765432100");
        paciente.setContato("11988888888");

        assertEquals("Joao Pereira", paciente.getNome());
        assertEquals(45, paciente.getIdade());
    }
}
