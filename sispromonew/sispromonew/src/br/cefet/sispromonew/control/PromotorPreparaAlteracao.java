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
import br.cefet.sispromonew.dao.PromotorDao;
import br.cefet.sispromonew.model.Cliente;
import br.cefet.sispromonew.model.Promotor;

/**
 * Servlet implementation class promotorPreparaAlteracao
 */
@WebServlet("/PromotorPreparaAlteracao")
public class PromotorPreparaAlteracao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PromotorPreparaAlteracao() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.valueOf(request.getParameter("id"));
		PromotorDao pDao = new PromotorDao();
		Promotor promotor = null;
		try {
			promotor = pDao.buscarUm(id);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		ClienteDao cliDao = new ClienteDao();
		List<Cliente> clientes = null;
		try {
			clientes = cliDao.buscarTodos();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("promotor", promotor);
		request.setAttribute("clientes", clientes);
		RequestDispatcher rd = request.getRequestDispatcher("/frmpromotor.jsp");
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
