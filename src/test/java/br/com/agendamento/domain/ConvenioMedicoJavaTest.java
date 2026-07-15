package br.com.agendamento.domain;

import br.com.agendamento.domain.model.ConvenioMedicoJava;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ConvenioMedicoJavaTest {

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
        ConvenioMedicoJava convenio = new ConvenioMedicoJava(null, "Unimed", new BigDecimal("350.00"));

        Set<ConstraintViolation<ConvenioMedicoJava>> violacoes = validator.validate(convenio);

        assertTrue(violacoes.isEmpty());
    }

    @Test
    void deveFalharQuandoMarcaForVazia() {
        ConvenioMedicoJava convenio = new ConvenioMedicoJava(null, "", new BigDecimal("350.00"));

        Set<ConstraintViolation<ConvenioMedicoJava>> violacoes = validator.validate(convenio);

        assertFalse(violacoes.isEmpty());
    }

    @Test
    void deveFalharQuandoValorForNuloOuNegativo() {
        ConvenioMedicoJava convenioNulo = new ConvenioMedicoJava(null, "Unimed", null);
        ConvenioMedicoJava convenioNegativo = new ConvenioMedicoJava(null, "Unimed", new BigDecimal("-10.00"));

        assertFalse(validator.validate(convenioNulo).isEmpty());
        assertFalse(validator.validate(convenioNegativo).isEmpty());
    }
}
