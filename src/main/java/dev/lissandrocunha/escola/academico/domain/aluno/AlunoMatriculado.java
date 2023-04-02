package dev.lissandrocunha.escola.academico.domain.aluno;

import java.time.LocalDateTime;
import java.util.Map;

import dev.lissandrocunha.escola.shared.domain.evento.Evento;
import dev.lissandrocunha.escola.shared.domain.evento.TipoDeEvento;
import dev.lissandrocunha.escola.shared.domain.vo.CPF;

public class AlunoMatriculado implements Evento {

    private final CPF cpf;
    private final LocalDateTime momento;

    public CPF getCpf() {
	return cpf;
    }

    public AlunoMatriculado(CPF cpf) {
	this.cpf = cpf;
	this.momento = LocalDateTime.now();
    }

    @Override
    public LocalDateTime momento() {
	return this.momento;
    }

    @Override
    public TipoDeEvento tipo() {
	return TipoDeEvento.ALUNO_MATRICULADO;
    }

    @Override
    public Map<String, Object> informacoes() {

	return Map.of("cpf", this.cpf);
    }

}
