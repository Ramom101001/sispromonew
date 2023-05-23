package br.cefet.sispromonew.control;

import java.io.IOException;
import java.sql.SQLException;

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
 * Servlet implementation class promotorAlterar
 */
@WebServlet("/PromotorAlterar")
public class PromotorAlterar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PromotorAlterar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
				String nome = request.getParameter("nome");
				String cpf = request.getParameter("cpf");
				String telefone = request.getParameter("telefone");
				int idCliente = Integer.valueOf(request.getParameter("idCliente"));
				int id = Integer.valueOf(request.getParameter("id"));

				
				
				
				ClienteDao cliDao= new ClienteDao();
				Cliente cliente = null;
				try {
					cliente = cliDao.buscarUm(idCliente);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				Promotor promotor = new Promotor();
				promotor.setId(id);
				promotor.setNome(nome);
				promotor.setCpf(cpf);
				promotor.setTelefone(telefone);
				
				
				PromotorDao pDao = new PromotorDao();
				try {
					pDao.alterar(promotor);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}
		
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
