package br.cefet.sispromonew.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.cefet.sispromonew.dao.ClienteDao;
import br.cefet.sispromonew.model.Cliente;
/**
 * Servlet implementation class ClienteAlterar
 */
@WebServlet("/ClienteAlterar")
public class ClienteAlterar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClienteAlterar() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id = Integer.valueOf(request.getParameter("id"));
		String nome = request.getParameter("nome");
		
		
		Cliente cliente = new Cliente();
		cliente.setId(id);
		cliente.setNome(nome);

		
		ClienteDao cliDao = new ClienteDao();
		try {
			cliDao.alterar(cliente);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
