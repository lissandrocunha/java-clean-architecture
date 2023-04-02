package dev.lissandrocunha.escola.infra.aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dev.lissandrocunha.escola.domain.aluno.Aluno;
import dev.lissandrocunha.escola.domain.aluno.AlunoNaoEncontrado;
import dev.lissandrocunha.escola.domain.aluno.AlunoRepository;
import dev.lissandrocunha.escola.domain.aluno.CPF;
import dev.lissandrocunha.escola.domain.aluno.Email;
import dev.lissandrocunha.escola.domain.aluno.Telefone;

public class AlunoRepositoryJDBC implements AlunoRepository {

    private final Connection connection;

    public AlunoRepositoryJDBC(Connection connection) {
	this.connection = connection;
    }

    @Override
    public void matricular(Aluno aluno) {
	try {
	    String sql = "INSERT INTO aluno VALUES (?,?,?)";
	    PreparedStatement ps = connection.prepareStatement(sql);
	    ps.setString(1, aluno.getCpf());
	    ps.setString(2, aluno.getNome());
	    ps.setString(3, aluno.getEmail());
	    ps.execute();

	    sql = "INSERT INTO telefone VALUES (?,?)";
	    ps = connection.prepareStatement(sql);
	    for (Telefone telefone : aluno.getTelefones()) {
		ps.setString(1, telefone.getDdd());
		ps.setString(2, telefone.getNumero());
	    }

	    ps.execute();
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}

    }

    @Override
    public Aluno buscarPorCPF(CPF cpf) {

	try {
	    String sql = "SELECT a.* FROM aluno a WHERE a.cpf = ?";
	    PreparedStatement ps = connection.prepareStatement(sql);
	    ps.setString(1, cpf.getNumero());

	    ResultSet rs = ps.executeQuery();
	    boolean encontrou = rs.next();
	    if (!encontrou) {
		throw new AlunoNaoEncontrado(cpf);
	    }

	    String nome = rs.getString("nome");
	    Email email = new Email(rs.getString("email"));
	    Aluno alunoEncontrado = new Aluno(cpf, nome, email);

	    Long id = rs.getLong("id");
	    sql = "SELECT t.* FROM telefone t WHERE t.aluno_id = ?";
	    ps = connection.prepareStatement(sql);
	    ps.setLong(1, id);
	    rs = ps.executeQuery();
	    while (rs.next()) {
		String ddd = rs.getString("ddd");
		String numero = rs.getString("numero");
		alunoEncontrado.adicionarTelefone(ddd, numero);
	    }

	    return alunoEncontrado;
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }

    @Override
    public List<Aluno> listarTodosAlunosMatriculados() {

	try {
	    String sql = "SELECT a.* FROM aluno a";
	    PreparedStatement ps = connection.prepareStatement(sql);
	    ResultSet rs = ps.executeQuery();
	    List<Aluno> alunos = new ArrayList<>();
	    while (rs.next()) {
		CPF cpf = new CPF(rs.getString("cpf"));
		String nome = rs.getString("nome");
		Email email = new Email(rs.getString("email"));
		Aluno aluno = new Aluno(cpf, nome, email);

		Long id = rs.getLong("id");
		sql = "SELECT t.* FROM telefone t WHERE t.aluno_id = ?";
		ps = connection.prepareStatement(sql);
		ps.setLong(1, id);
		ResultSet rsTelefone = ps.executeQuery();
		while (rs.next()) {
		    String ddd = rsTelefone.getString("ddd");
		    String numero = rsTelefone.getString("numero");
		    aluno.adicionarTelefone(ddd, numero);
		}
		alunos.add(aluno);
	    }

	    return alunos;
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }

}
