package br.cefet.sispromonew.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.cefet.sispromonew.dao.ClienteDao;
import br.cefet.sispromonew.model.Cliente;
/**
 * Servlet implementation class ServletListarCliente
 */
@WebServlet("/ServletListarCliente")
public class ServletListarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListarCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ClienteDao cliDao = new ClienteDao();
		
		
		List<Cliente> clientes = null;
		try {
			clientes = cliDao.buscarTodos();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		String np = request.getParameter("np");
		request.setAttribute("clientes", clientes);
		RequestDispatcher rd = request.getRequestDispatcher(np);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
