package br.iss.ecommerce.servlet.usr;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.iss.ecommerce.domain.Grade;
import br.iss.ecommerce.domain.Usuario;

/**
 * Servlet implementation class Usuario_Create
 */
@WebServlet("/usuario/create")
public class Usuario_Create extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Usuario_Create() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Passa as informações básicas da página.
		request.setAttribute("page_title", 				"Cadastro de Usuario");
		request.setAttribute("page_description", 		"Novo Usuario.");				
		
		// Cria uma grade vazia.
		Usuario usuario = new Usuario();
		
		// Passa os dados para a view.
		request.setAttribute("usuario", usuario);
		
		// Chama a View.
		request.getRequestDispatcher("/view/usuario/usuario_create.jsp").forward(request, response);
	}

}
