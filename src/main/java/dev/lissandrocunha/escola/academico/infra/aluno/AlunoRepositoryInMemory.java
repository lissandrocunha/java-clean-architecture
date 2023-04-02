package dev.lissandrocunha.escola.academico.infra.aluno;

import java.util.ArrayList;
import java.util.List;

import dev.lissandrocunha.escola.academico.domain.aluno.Aluno;
import dev.lissandrocunha.escola.academico.domain.aluno.AlunoNaoEncontrado;
import dev.lissandrocunha.escola.academico.domain.aluno.AlunoRepository;
import dev.lissandrocunha.escola.shared.domain.vo.CPF;

public class AlunoRepositoryInMemory implements AlunoRepository {

    private List<Aluno> matriculados = new ArrayList<>();

    @Override
    public void matricular(Aluno aluno) {
	this.matriculados.add(aluno);
    }

    @Override
    public Aluno buscarPorCPF(CPF cpf) {
	return this.matriculados.stream().filter(a -> a.getCpf().getNumero().equals(cpf.getNumero())).findFirst()
		.orElseThrow(() -> new AlunoNaoEncontrado(cpf));
    }

    @Override
    public List<Aluno> listarTodosAlunosMatriculados() {
	return this.matriculados;
    }

}
