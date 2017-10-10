package br.iss.ecommerce.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class AdminFilter
 */
@WebFilter("/adm/*")
public class AdminFilter implements Filter {

    public AdminFilter() {
    }

	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		// Converte a requisição.
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		
		// Passa a variável correpondente à URL básica do site.
		request.setAttribute("base_url", 	request.getScheme() + "://" + 
											request.getServerName() + ":" + 
											request.getServerPort() + 
											httpRequest.getContextPath());

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
