package dev.lissandrocunha.escola.academico.application.aluno.matricular;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import dev.lissandrocunha.escola.academico.application.aluno.matricular.MatricularAluno;
import dev.lissandrocunha.escola.academico.application.aluno.matricular.MatricularAlunoDto;
import dev.lissandrocunha.escola.academico.domain.aluno.Aluno;
import dev.lissandrocunha.escola.academico.domain.aluno.AlunoRepository;
import dev.lissandrocunha.escola.academico.infra.aluno.AlunoRepositoryInMemory;
import dev.lissandrocunha.escola.shared.domain.evento.PublicadorDeEventos;
import dev.lissandrocunha.escola.shared.domain.vo.CPF;

class MatricularAlunoTest {

    @Test
    void alunoDeveSerPersistido() {
	AlunoRepository repository = new AlunoRepositoryInMemory();
	PublicadorDeEventos publicar = new PublicadorDeEventos();
	MatricularAluno useCase = new MatricularAluno(repository, publicar);
	String nome = "Fulano";
	String cpf = "123.456.789-00";
	String email = "fulano@domain.com";

	MatricularAlunoDto dados = new MatricularAlunoDto(nome, cpf, email);
	useCase.executar(dados);

	Aluno expected = repository.buscarPorCPF(new CPF(cpf));

	assertEquals(expected.getNome(), nome);
	assertEquals(expected.getCpf().getNumero(), cpf);
	assertEquals(expected.getEmail(), email);
    }

}
