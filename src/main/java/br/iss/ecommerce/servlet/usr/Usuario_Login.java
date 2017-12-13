package br.iss.ecommerce.servlet.usr;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.iss.ecommerce.dao.UsuarioDAO;

/**
 * Servlet implementation class Usuario_Login
 */
@WebServlet("/user/Auth")
public class Usuario_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Usuario_Login() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String 	login = request.getParameter("login");
		String 	senha = request.getParameter("senha");
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		
		boolean autenticado = usuarioDao.tryLogin(login, senha);
	}

}
