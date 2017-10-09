package br.iss.ecommerce.filter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class GenericFilter
 */
@WebFilter(
	dispatcherTypes = {
		DispatcherType.REQUEST, 
		DispatcherType.FORWARD, 
		DispatcherType.INCLUDE, 
		DispatcherType.ERROR
	}, 
	urlPatterns = { "/adm/*" }
)
public class AdminFilter implements Filter {

    public AdminFilter() {}

	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		// Array vazia de arquivos .js a serem importados pelo view.
		String[] scripts = {};
		request.setAttribute("scripts", scripts);

		// Array vazia de arquivos .css a serem importados pelo view.
		String[] styles = {};
		request.setAttribute("styles", styles);
		
		// Passa a requisição para frente.
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {}

}
