package dev.lissandrocunha.escola;

import dev.lissandrocunha.escola.domain.aluno.Aluno;
import dev.lissandrocunha.escola.domain.aluno.AlunoRepository;
import dev.lissandrocunha.escola.domain.aluno.CPF;
import dev.lissandrocunha.escola.domain.aluno.Email;
import dev.lissandrocunha.escola.infra.aluno.AlunoRepositoryInMemory;

public class ApplicationEscola {

    public static void main(String[] args) {
	String nome = "Aluno 1";
	CPF cpf = new CPF("111.111.111-11");
	Email email = new Email("aluno1@domain.com");

	Aluno aluno = new Aluno(cpf, nome, email);

	AlunoRepository repositorio = new AlunoRepositoryInMemory();
	repositorio.matricular(aluno);
    }

}
