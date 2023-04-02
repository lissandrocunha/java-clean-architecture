package dev.lissandrocunha.escola.gamificacao.domain.selo;

import java.util.List;

import dev.lissandrocunha.escola.shared.domain.vo.CPF;

public interface SeloRepository {

    void adicionar(Selo selo);

    List<Selo> selosDoAlunoPorCPF(CPF cpf);

}
