package dev.lissandrocunha.escola;

import dev.lissandrocunha.escola.academico.application.aluno.matricular.MatricularAluno;
import dev.lissandrocunha.escola.academico.application.aluno.matricular.MatricularAlunoDto;
import dev.lissandrocunha.escola.academico.domain.aluno.Email;
import dev.lissandrocunha.escola.academico.domain.aluno.LogAlunoMatriculado;
import dev.lissandrocunha.escola.academico.infra.aluno.AlunoRepositoryInMemory;
import dev.lissandrocunha.escola.gamificacao.application.GeraSeloAnuloNovato;
import dev.lissandrocunha.escola.gamificacao.infra.selo.SeloRepositoryInMemory;
import dev.lissandrocunha.escola.shared.domain.evento.PublicadorDeEventos;
import dev.lissandrocunha.escola.shared.domain.vo.CPF;

public class ApplicationEscola {

    public static void main(String[] args) {
	String nome = "Aluno 1";
	CPF cpf = new CPF("111.111.111-11");
	Email email = new Email("aluno1@domain.com");

	MatricularAlunoDto dto = new MatricularAlunoDto(nome, cpf.getNumero(), email.getEndereco());

	PublicadorDeEventos publicador = new PublicadorDeEventos();
	publicador.adicionar(new LogAlunoMatriculado());
	publicador.adicionar(new GeraSeloAnuloNovato(new SeloRepositoryInMemory()));

	MatricularAluno matricular = new MatricularAluno(new AlunoRepositoryInMemory(), publicador);
	matricular.executar(dto);
    }

}
