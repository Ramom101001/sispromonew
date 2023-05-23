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
 * Servlet implementation class ServletRegistrarCliente
 */
@WebServlet("/ServletRegistrarCliente")
public class ServletRegistrarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRegistrarCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String cnpj = request.getParameter("cnpj");
		String cep = request.getParameter("cep");
		String endereco = request.getParameter("endereco");
		String numero = request.getParameter("numero");
		String complemento = request.getParameter("complemento");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String uf = request.getParameter("uf");
		int idPromotor = Integer.valueOf(request.getParameter("idPromotor"));
		
		//Buscar promotor de acordo com o ID
		PromotorDao pDao = new PromotorDao();
		Promotor promotor = null;
		
		try {
			promotor = pDao.buscarUm(idPromotor);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setCpnj(cnpj);
		cliente.setCep(cep);
		cliente.setEndereco(endereco);
		cliente.setNumero(numero);
		cliente.setComplemento(complemento);
		cliente.setBairro(bairro);
		cliente.setCidade(cidade);
		cliente.setUf(uf);
		
		
		ClienteDao cliDao = new ClienteDao();
		
		try {
			cliDao.adicionar(cliente);
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
