package dev.lissandrocunha.escola.gamificacao.domain.selo;

import dev.lissandrocunha.escola.shared.domain.vo.CPF;

public class Selo {

    private CPF cpf;
    private String nome;

    public CPF getCpf() {
	return cpf;
    }

    public String getNome() {
	return nome;
    }

    public Selo(CPF cpf, String nome) {
	super();
	this.cpf = cpf;
	this.nome = nome;
    }

}
