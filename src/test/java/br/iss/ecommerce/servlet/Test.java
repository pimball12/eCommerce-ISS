package br.iss.ecommerce.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.iss.ecommerce.domain.Endereco;

/**
 * Não roda, só pra gravar os exemplos.
 */
@WebServlet("/test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Test() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String x = (String)request.getParameter("num");
		response.getWriter().append("Served located " + x + " at: ").append(request.getContextPath());
		
		// Passar um objeto.
  		Endereco endereco = new Endereco();
  		endereco.setRua("Umuarama");
  		request.setAttribute("teste", endereco);			
		
  		// Passar arquivos .js ou .css 
  		String[] scripts = {"hello", "world"};
  		request.setAttribute("scripts", scripts);
  		
  		String[] styles = {"hello", "world"};
  		request.setAttribute("styles", styles);
	}

}
