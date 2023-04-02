package dev.lissandrocunha.escola.academico.application.aluno.matricular;

import dev.lissandrocunha.escola.academico.domain.aluno.Aluno;
import dev.lissandrocunha.escola.academico.domain.aluno.AlunoMatriculado;
import dev.lissandrocunha.escola.academico.domain.aluno.AlunoRepository;
import dev.lissandrocunha.escola.shared.domain.evento.PublicadorDeEventos;

public class MatricularAluno {

    private final AlunoRepository alunoRepository;
    private final PublicadorDeEventos publicador;

    public MatricularAluno(AlunoRepository alunoRepository, PublicadorDeEventos publicador) {
	this.alunoRepository = alunoRepository;
	this.publicador = publicador;
    }

    public void executar(MatricularAlunoDto dados) {
	Aluno aluno = dados.criarAluno();
	alunoRepository.matricular(aluno);

	AlunoMatriculado evento = new AlunoMatriculado(aluno.getCpf());
	publicador.publicar(evento);

    }

}
