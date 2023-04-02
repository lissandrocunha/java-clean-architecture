package dev.lissandrocunha.escola.application.aluno.matricular;

import dev.lissandrocunha.escola.domain.aluno.Aluno;
import dev.lissandrocunha.escola.domain.aluno.AlunoRepository;

public class MatricularAluno {

    private final AlunoRepository alunoRepository;

    public MatricularAluno(AlunoRepository alunoRepository) {
	this.alunoRepository = alunoRepository;
    }

    public void executar(MatricularAlunoDto dados) {
	Aluno aluno = dados.criarAluno();
	alunoRepository.matricular(aluno);
    }

}
