package dev.lissandrocunha.escola.academico.domain.aluno;

import java.time.format.DateTimeFormatter;

import dev.lissandrocunha.escola.shared.domain.evento.Evento;
import dev.lissandrocunha.escola.shared.domain.evento.Ouvinte;
import dev.lissandrocunha.escola.shared.domain.evento.TipoDeEvento;

public class LogAlunoMatriculado extends Ouvinte {

    @Override
    public void reageAo(Evento evento) {
	String momentoFormatado = evento.momento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));

	System.out.println(String.format("Aluno com %s matriculado em: %s", ((AlunoMatriculado) evento).getCpf(),
		momentoFormatado));

    }

    @Override
    public boolean deveProcessar(Evento evento) {
	return evento.tipo() == TipoDeEvento.ALUNO_MATRICULADO;
    }

}
