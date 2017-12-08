package br.iss.ecommerce.servlet.usr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.iss.ecommerce.domain.Usuario;
import br.iss.ecommerce.dao.UsuarioDAO;


/**
 * Servlet implementation class Usuario_Post
 */
@WebServlet("/usuario/post")
public class Usuario_Post extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Usuario_Post() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// // Cria os objetos DAO.
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		// Define os objetos de Persistência.
		Usuario usuario;
		
		// Recupera as propriedades da grade.
		long 	id 		= Long.parseLong(request.getParameter("id").trim());
		String 	nome	= request.getParameter("usuario_nome");
		
		// Verifica se é inserção ou atualização.
		if (id == 0)			
			usuario = new Usuario();
		else 			
			usuario = UsuarioDAO.find(id);		
		
		// Passa os outros atributos. 
		usuario.setNome(nome);
		
		// Salva o item e seta a mensagem de sucesso.
		if (id == 0)	{	
			usuarioDAO.save(usuario);
			request.getSession().setAttribute("flash_message_text", "usuario adicionada com sucesso.");
		} else {
			usuarioDAO.update(usuario);
			request.getSession().setAttribute("flash_message_text", "Usuario editada com sucesso.");
		}
			
		// Seta o tipo de mensagem como de sucesso e redireciona para a tela de edição daquela grade.
		request.getSession().setAttribute("flash_message_kind", "success");
		response.sendRedirect(	request.getAttribute("base_url") + 
								"/usuario/main.jsp");  		

	}

}
