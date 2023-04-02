package dev.lissandrocunha.escola.academico.domain.aluno;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import dev.lissandrocunha.escola.shared.domain.vo.CPF;

class CPFTest {

    @Test
    void naoDeveriaCriarCPFComNumerosInvalidos() {
	assertThrows(IllegalArgumentException.class, () -> new CPF(null));

	assertThrows(IllegalArgumentException.class, () -> new CPF(""));

	assertThrows(IllegalArgumentException.class, () -> new CPF("12345678900"));
    }

    @Test
    void deveriaPermitirCriarCPFComNumeroValido() {
	String numero = "123.456.789-00";
	CPF cpf = new CPF(numero);
	assertEquals(numero, cpf.getNumero());
    }

}