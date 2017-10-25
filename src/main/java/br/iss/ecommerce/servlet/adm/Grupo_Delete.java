package br.iss.ecommerce.servlet.adm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.iss.ecommerce.dao.GrupoDAO;
import br.iss.ecommerce.domain.Grupo;
import br.iss.ecommerce.util.HibernateUtil;


@WebServlet("/adm/grupo/delete")
public final class Grupo_Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Grupo_Delete() {
        
    	super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		long id = Long.parseLong(request.getParameter("id").trim());

		GrupoDAO grupoDAO = new GrupoDAO();
		Grupo grupo = grupoDAO.find(id);
		grupoDAO.delete(grupo);

		request.getSession().setAttribute("flash_message_text", "Grupo excluído com sucesso.");
		request.getSession().setAttribute("flash_message_kind", "success");

		response.sendRedirect(request.getAttribute("base_url") + "/adm/grupo");  
	}

}
