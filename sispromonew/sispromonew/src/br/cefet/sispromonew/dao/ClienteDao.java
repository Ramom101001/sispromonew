package br.cefet.sispromonew.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.cefet.sispromonew.model.Cliente;

public class ClienteDao {
	private Connection con = null;
	
	public ClienteDao() {
		con = ConnectionFactory.getConnection();
	}
	
	public void adicionar(Cliente cliente) throws SQLException {
		
		String sql = " insert into cliente(nome,cnpj, cep, endereco, "
				+ " complemento, numero, bairro, cidade, uf)"
				+ " values (?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, cliente.getNome());
		stmt.setString(2, cliente.getCpnj());
		stmt.setString(3, cliente.getCep());
		stmt.setString(4, cliente.getEndereco());
		stmt.setString(5, cliente.getComplemento());
		stmt.setString(6, cliente.getNumero());
		stmt.setString(7, cliente.getBairro());
		stmt.setString(8, cliente.getCidade());
		stmt.setString(9, cliente.getUf());
		
		
		stmt.execute();
		stmt.close();
		con.close();

	}
	
	public void delete(Cliente cliente) throws SQLException {
		String sql = "delete from cliente where id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, cliente.getId());
		stmt.execute();
		stmt.close();
		con.close();
	}
	
	public void alterar(Cliente cliente) throws SQLException {
		String sql = "update cliente set nome = ? "
				+ " where id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, cliente.getNome());
		stmt.setInt(2, cliente.getId());
		stmt.execute();
		stmt.close();
		con.close();
	}
	
	public Cliente buscarUm(int id) throws SQLException {
		String sql = "select id, nome from cliente "
				+ " where id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		Cliente cliente = null;
		if (rs.next()) {
			cliente = new Cliente();
			cliente.setId(rs.getInt("id"));
			cliente.setNome(rs.getString("nome"));
		}
		stmt.close();
		con.close();
		return cliente;
	}
	
	
	public List<Cliente> buscarTodos() throws SQLException {
		String sql = "select id, nome from cliente";
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		Cliente cliente = null;
		List<Cliente> clientes = new ArrayList<Cliente>();
		while (rs.next()) {
			cliente = new Cliente();
			cliente.setId(rs.getInt("id"));
			cliente.setNome(rs.getString("nome"));
			clientes.add(cliente);
		}
		stmt.close();
		con.close();
		return clientes;
	}
	
	
	
	

}
