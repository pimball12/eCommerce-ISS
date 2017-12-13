package br.iss.ecommerce.servlet.usr;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.iss.ecommerce.dao.UsuarioDAO;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Login() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		request.getRequestDispatcher("/view/user/login.jsp").forward(request, response);
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		String mensagemTexto, mensagemTipo, uri;
		
		boolean autenticado = usuarioDao.tryLogin(login, senha);
				
		if (autenticado) {
			mensagemTexto = "Autenticado com sucesso!";
			mensagemTipo = "success";
			uri = "/user/main.jsp";
		}else {
			mensagemTexto = "Falha de Autenticacao!";
			mensagemTipo = "error";
			uri = "user/login.jsp";
		}
		request.getSession().setAttribute("flash_message_text", mensagemTexto);
		request.getSession().setAttribute("flash_message_kind", mensagemTipo);
		response.sendRedirect(request.getAttribute("base_url") + uri); 
	}
}
