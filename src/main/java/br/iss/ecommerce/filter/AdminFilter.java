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
		
		// Verifica se existe a variável que controla a barra lateral e define ela.		
		if (httpRequest.getSession(true).getAttribute("sidebar_collapse") == null)	
			httpRequest.getSession().setAttribute("sidebar_collapse", true);
		
		boolean sidebarCollapse = (boolean)httpRequest.getSession().getAttribute("sidebar_collapse");
		
		request.setAttribute("sidebar_collapse", (sidebarCollapse) ? "sidebar-collapse" : "");
		
		// Verifica se foi setada uma mensagem temporária, e define ela. Para mensagens de erro e de sucesso.
		if ((httpRequest.getSession().getAttribute("flash_message_text") != null) &&
			(httpRequest.getSession().getAttribute("flash_message_kind") != null)){
			
			String messageText = (String)httpRequest.getSession().getAttribute("flash_message_text");
			String messageKind = (String)httpRequest.getSession().getAttribute("flash_message_kind");
			httpRequest.getSession().removeAttribute("flash_message_text");
			httpRequest.getSession().removeAttribute("flash_message_kind");
			
			request.setAttribute("flash_message_text", 	messageText);
			request.setAttribute("flash_message",	 	true);
			
			if 			(messageKind.equals("error"))	{
				
				request.setAttribute("flash_message_icon", "fa-ban");
				request.setAttribute("flash_message_kind", "alert-danger");				
			} else if 	(messageKind.equals("info")) {

				request.setAttribute("flash_message_icon", "fa-exclamation");
				request.setAttribute("flash_message_kind", "alert-info");
			} else if 	(messageKind.equals("success")) {
				
				request.setAttribute("flash_message_icon", "fa-check-square");
				request.setAttribute("flash_message_kind", "alert-success");					
			}
		}

		// Continua a cadeia de requisições.
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
