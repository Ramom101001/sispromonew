
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
 * Servlet implementation class ServletRegistrarPromotor
 */
@WebServlet("/ServletRegistrarPromotor")
public class ServletRegistrarPromotor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRegistrarPromotor() {
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
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");


		
		
		
		Promotor promotor = new Promotor();
		promotor.setNome(nome);
		promotor.setCpf(cpf);
		promotor.setTelefone(telefone);
		promotor.setLogin(login);
		promotor.setSenha(senha);
		
		PromotorDao pDao = new PromotorDao();
		try {
			pDao.adicionar(promotor);
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
