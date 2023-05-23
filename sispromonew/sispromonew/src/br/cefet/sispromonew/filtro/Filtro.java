package br.cefet.sispromonew.filtro;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.cefet.sispromonew.model.Cliente;
import br.cefet.sispromonew.model.Promotor;

/**
 * Servlet Filter implementation class Filtro
 */
@WebFilter("/*")
public class Filtro implements Filter {

    /**
     * Default constructor. 
     */
    public Filtro() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("Entrou no filtro");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		// Pegando a url destino
		String url = req.getRequestURI();
		System.out.println("URL de acesso:" + url);

		// Pegando a sessao
		HttpSession session = req.getSession();
		System.out.println("Id da session" + session.getId());

		// Pegar o cliente
		Promotor promotor = (Promotor) session.getAttribute("promotor");

		//
		// Cliente nao logado
		if (promotor == null) 
			if (url.endsWith("index.jsp") || 
				url.endsWith("ServletLogar") || 
				url.endsWith("frmpromotor.jsp") || 
				url.endsWith("ServletRegistrarPromotor"))
				chain.doFilter(request, response);
			else
				res.sendRedirect("index.jsp");
		 else  // cliete logado
			chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
