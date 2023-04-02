package dev.lissandrocunha.escola.gamificacao.application;

import java.time.format.DateTimeFormatter;

import dev.lissandrocunha.escola.gamificacao.domain.selo.Selo;
import dev.lissandrocunha.escola.gamificacao.domain.selo.SeloRepository;
import dev.lissandrocunha.escola.shared.domain.evento.Evento;
import dev.lissandrocunha.escola.shared.domain.evento.Ouvinte;
import dev.lissandrocunha.escola.shared.domain.evento.TipoDeEvento;
import dev.lissandrocunha.escola.shared.domain.vo.CPF;

public class GeraSeloAnuloNovato extends Ouvinte {

    private final SeloRepository seloRepository;

    public GeraSeloAnuloNovato(SeloRepository seloRepository) {
	this.seloRepository = seloRepository;
    }

    @Override
    public void reageAo(Evento evento) {
	String momento = evento.momento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
	CPF cpf = (CPF) evento.informacoes().get("cpf");
	Selo novato = new Selo(cpf, "Novato");

	seloRepository.adicionar(novato);
	System.out.println(String.format("Selo de Novato gerado para o %s em: %s", cpf.toString(), momento));
    }

    @Override
    public boolean deveProcessar(Evento evento) {
	return evento.tipo() == TipoDeEvento.ALUNO_MATRICULADO;
    }

}
