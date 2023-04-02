package dev.lissandrocunha.escola.academico.domain.aluno;

import java.util.List;

import dev.lissandrocunha.escola.shared.domain.vo.CPF;

public interface AlunoRepository {

    void matricular(Aluno aluno);

    Aluno buscarPorCPF(CPF cpf);

    List<Aluno> listarTodosAlunosMatriculados();

}
