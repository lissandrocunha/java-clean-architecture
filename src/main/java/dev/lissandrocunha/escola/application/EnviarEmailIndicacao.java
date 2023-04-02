package dev.lissandrocunha.escola.application;

import dev.lissandrocunha.escola.domain.aluno.Aluno;

public interface EnviarEmailIndicacao {

    void enviarPara(Aluno indicado);

}
