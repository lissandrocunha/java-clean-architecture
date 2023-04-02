package dev.lissandrocunha.escola.academico.domain.aluno;

import dev.lissandrocunha.escola.shared.domain.vo.CPF;

public class AlunoNaoEncontrado extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AlunoNaoEncontrado(CPF cpf) {
	super("Aluno nao encontrado com CPF: " + cpf.getNumero());
    }

}
