package br.cefet.sispromonew.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.cefet.sispromonew.dao.PromotorDao;
import br.cefet.sispromonew.model.Promotor;

/**
 * Servlet implementation class ServletLogar
 */
@WebServlet("/ServletLogar")
public class ServletLogar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		Promotor promotor = null;
		PromotorDao promoDao = new PromotorDao();
		
		try {
			promotor = promoDao.logar(login, senha);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Trabalhando com Session
		HttpSession session = request.getSession();
		session.setAttribute("promotor", promotor);
		
		// Cliente n�o logado voltar para p�gina de login
		String nextPage = null; 
		if(promotor == null) {
			request.setAttribute("msg", "Login inv�lido!");
			nextPage = "/index.jsp"; 
		} else {
	        // Verificar o tipo de login
	        if (login.equals("admin")) {
	            // Login do administrador com acesso amplo
	            nextPage = "/menu.html";
	        } else {
	            // Outros logins com acesso restrito
	            nextPage = "/listarcliente.jsp";
	        }
	    }
		
		RequestDispatcher rd = request.getRequestDispatcher(nextPage);
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
