package dev.lissandrocunha.escola.academico.domain.aluno;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import dev.lissandrocunha.escola.academico.domain.aluno.Email;

class EmailTest {

    @Test
    void naoDeveriaCriarEmailsComEnderecosInvalidos() {
	assertThrows(IllegalArgumentException.class, () -> new Email(null));

	assertThrows(IllegalArgumentException.class, () -> new Email(""));

	assertThrows(IllegalArgumentException.class, () -> new Email("emailinvalido"));
    }

    @Test
    void deveriaPermitirCriarEmailComEnderecoValido() {
	String endereco = "fulano@alura.com.br";
	Email email = new Email(endereco);
	assertEquals(endereco, email.getEndereco());
    }

}