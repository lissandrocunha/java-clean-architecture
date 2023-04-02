package dev.lissandrocunha.escola.gamificacao.infra.selo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dev.lissandrocunha.escola.gamificacao.domain.selo.Selo;
import dev.lissandrocunha.escola.gamificacao.domain.selo.SeloRepository;
import dev.lissandrocunha.escola.shared.domain.vo.CPF;

public class SeloRepositoryInMemory implements SeloRepository {

    private List<Selo> selos = new ArrayList<>();

    @Override
    public void adicionar(Selo selo) {
	this.selos.add(selo);
    }

    @Override
    public List<Selo> selosDoAlunoPorCPF(CPF cpf) {
return this.selos.stream().filter(s -> s.getCpf().equals(cpf)).collect(Collectors.toList());
	}

}
