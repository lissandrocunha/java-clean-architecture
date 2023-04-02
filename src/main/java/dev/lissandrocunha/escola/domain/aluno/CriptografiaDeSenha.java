package dev.lissandrocunha.escola.domain.aluno;

public interface CriptografiaDeSenha {

    String criptografar(String senha);

    Boolean validarSenha(String senhaCriptografada, String senha);
}
