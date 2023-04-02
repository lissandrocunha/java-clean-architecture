package dev.lissandrocunha.escola.academico.application.indicacao;

import dev.lissandrocunha.escola.academico.domain.aluno.Aluno;

public interface EnviarEmailIndicacao {

    void enviarPara(Aluno indicado);

}
