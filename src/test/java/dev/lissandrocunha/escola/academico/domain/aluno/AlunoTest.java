package dev.lissandrocunha.escola.academico.domain.aluno;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.lissandrocunha.escola.academico.domain.aluno.Aluno;
import dev.lissandrocunha.escola.academico.domain.aluno.Email;
import dev.lissandrocunha.escola.shared.domain.vo.CPF;

class AlunoTest {

    private Aluno aluno;

    @BeforeEach
    void beforeEach() {
	this.aluno = new Aluno(new CPF("123.456.789-00"), "Fulano da Silva", new Email("fulano.silva@domain.com"));

    }

    @Test
    void devePermitirCadastrar1Telefone() {
	this.aluno.adicionarTelefone("00", "123456789");
	assertEquals(1, this.aluno.getTelefones().size());
    }

    @Test
    void devePermitirCadastrar2Telefone() {
	this.aluno.adicionarTelefone("00", "123456789");
	this.aluno.adicionarTelefone("11", "987654321");
	assertEquals(2, this.aluno.getTelefones().size());
    }

    @Test
    void naoDevePermitirCadastrar3Telefone() {
	assertThrows(IllegalArgumentException.class, () -> {
	    this.aluno.adicionarTelefone("00", "123456789");
	    this.aluno.adicionarTelefone("11", "987654321");
	    this.aluno.adicionarTelefone("22", "012345678");
	});

    }

}
