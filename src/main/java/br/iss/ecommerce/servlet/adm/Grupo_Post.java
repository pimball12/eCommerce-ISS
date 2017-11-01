package br.iss.ecommerce.servlet.adm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.iss.ecommerce.dao.GradeDAO;
import br.iss.ecommerce.dao.GrupoDAO;
import br.iss.ecommerce.domain.Grade;
import br.iss.ecommerce.domain.Grupo;
import br.iss.ecommerce.util.HibernateUtil;


@WebServlet("/adm/grupo/post")
public class Grupo_Post extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Grupo_Post() {
        
    	super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		GrupoDAO GrupoDAO = new GrupoDAO();
		

		Grupo grupo;
		long 	id = Long.parseLong(request.getParameter("id").trim());
		String 	nome = request.getParameter("grupo_nome");
		
		if (id == 0)			
			grupo = new Grupo();
		else 			
			grupo = GrupoDAO.find(id);		
		
		grupo.setNome(nome);
		
		if (id == 0)	{	
			GrupoDAO.save(grupo);
			request.getSession().setAttribute("flash_message_text", "Grupo adicionada com sucesso.");
		} else {
			GrupoDAO.update(grupo);
			request.getSession().setAttribute("flash_message_text", "Grupo editada com sucesso.");
		}
			
		request.getSession().setAttribute("flash_message_kind", "success");
		response.sendRedirect(	request.getAttribute("base_url") + 
								"/adm/grupo/edit?id=" + grupo.getId());  		
	}

}
