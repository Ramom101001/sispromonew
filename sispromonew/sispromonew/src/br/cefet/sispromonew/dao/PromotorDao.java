package br.cefet.sispromonew.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.cefet.sispromonew.model.Promotor;
public class PromotorDao {
	private Connection con = null;
	
	public PromotorDao() {
		con = ConnectionFactory.getConnection();
	}

	public void adicionar(Promotor promotor) throws SQLException {
		// SQL para inserir um promotor
		String sql = "insert into promotor(nome,cpf,telefone, login, senha) "
				+ " values (?,?,?,?,?)";
		// Preparar a SQL
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, promotor.getNome());
		stmt.setString(2, promotor.getCpf());
		stmt.setString(3, promotor.getTelefone());
		stmt.setString(4, promotor.getLogin());
		stmt.setString(5, promotor.getSenha());
		// Executar e fechar as conex�es
		stmt.execute();
		stmt.close();
		con.close();
	}
	
	public void delete(Promotor promotor) throws SQLException {
		String sql = "delete from promotor where id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, promotor.getId());
		stmt.execute();
		stmt.close();
		con.close();
	}
	
	public List<Promotor> buscar(String texto) throws SQLException {
		String sql = "select id, nome,cpf,telefone from "
				+ " promotor where nome like ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		texto = "%" + texto + "%";
		stmt.setString(1, texto);
		ResultSet rs = stmt.executeQuery();
		
		Promotor promotor = null;
		List<Promotor> promotores = new ArrayList<Promotor>();
		
		while (rs.next()) {
			promotor = new Promotor();
			promotor.setId(rs.getInt("id"));
			promotor.setNome(rs.getString("nome"));
			promotor.setCpf(rs.getString("cpf"));
			promotor.setTelefone(rs.getString("telefone"));
			promotores.add(promotor);
		}
		stmt.close();
		con.close();
		return promotores;
	}
	
	public Promotor buscarUm(int id) throws SQLException {
		String sql = "select id, nome,cpf,telefone from "
				+ " promotor where id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		
		Promotor promotor = null;
		if (rs.next()) {
			promotor = new Promotor();
			promotor.setId(rs.getInt("id"));
			promotor.setNome(rs.getString("nome"));
			promotor.setCpf(rs.getString("cpf"));
			promotor.setTelefone(rs.getString("telefone"));
			
		}
		stmt.close();
		con.close();
		return promotor;
	}

	
	public void alterar(Promotor promotor) throws SQLException {
		
		String sql = "update promotor set nome = ?, cpf = ?, telefone = ?,"
				+ " where id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, promotor.getNome());
		stmt.setString(2, promotor.getCpf());
		stmt.setString(3, promotor.getTelefone());
		stmt.setInt(4, promotor.getId());
		
		stmt.execute();
		stmt.close();
		con.close();
	}
	
	public Promotor logar(String l, String s) throws SQLException {
		String sql = "select id, nome, login, senha from promotor"
				+ " where login = ? and senha = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, l);
		stmt.setString(2, s);
		ResultSet rs = stmt.executeQuery();
		Promotor promotor = null;
		if (rs.next()) {
			promotor = new Promotor();
			promotor.setId(rs.getInt("id"));
			promotor.setNome(rs.getString("nome"));
			promotor.setLogin(rs.getString("login"));
			promotor.setSenha(rs.getString("senha"));
		}
		stmt.close();
		con.close();
		return promotor;
	}
	
	
}
