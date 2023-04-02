package dev.lissandrocunha.escola.academico.application.aluno.matricular;

import dev.lissandrocunha.escola.academico.domain.aluno.Aluno;
import dev.lissandrocunha.escola.academico.domain.aluno.Email;
import dev.lissandrocunha.escola.shared.domain.vo.CPF;

public class MatricularAlunoDto {

    private String nome;
    private String cpf;
    private String email;

    public MatricularAlunoDto(String nome, String cpf, String email) {
	super();
	this.nome = nome;
	this.cpf = cpf;
	this.email = email;
    }

    public Aluno criarAluno() {
	return new Aluno(new CPF(this.cpf), this.nome, new Email(this.email));
    }

}
