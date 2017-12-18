package br.iss.ecommerce.filter;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import br.iss.ecommerce.domain.Estoque;

/**
 * Servlet Filter implementation class GeneralFilter
 */
@WebFilter("/*")
public class GeneralFilter implements Filter {

    public GeneralFilter() {

    }


	public void destroy() {

	}


	@SuppressWarnings("unchecked")
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		// Converte a requisição.
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		
		// Passa a variável correpondente à URL básica do site.
		request.setAttribute("base_url", 	request.getScheme() + "://" + 
											request.getServerName() + ":" + 
											request.getServerPort() + 
											httpRequest.getContextPath());
		
		// Verifica se ha usuario na sessao e cria ele.
		if (httpRequest.getSession().getAttribute("user") != null)
			httpRequest.setAttribute("user", httpRequest.getSession().getAttribute("user"));
		
		// Verifica se já existe um carrinho e se não houver, cria ele.
		if (httpRequest.getSession().getAttribute("cart") == null)
			httpRequest.getSession().setAttribute("cart", new LinkedList<Estoque>());
		
		// Soma o carrinho e suas quantidades, e então seta essas variáveis.
		List<Estoque> cart = ((LinkedList<Estoque>)httpRequest.getSession().getAttribute("cart"));
		BigDecimal total = new BigDecimal(0);	
		for(Estoque estoque : cart)	
			total = total.add(estoque.getProduto().getPreco());
		request.setAttribute("cart_quant", cart.size());
		request.setAttribute("cart_total", total);
		
		// Continua a cadeia.
		chain.doFilter(request, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {

	}

}
