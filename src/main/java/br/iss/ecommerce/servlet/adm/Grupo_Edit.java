package br.iss.ecommerce.servlet.adm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.iss.ecommerce.dao.GrupoDAO;
import br.iss.ecommerce.domain.Grupo;

@WebServlet("/adm/grupo/edit")
public class Grupo_Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Grupo_Edit() {
        
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			request.setAttribute("page_title", 				"Grupos");
			request.setAttribute("page_description", 		"Editar Grupo.");	

			GrupoDAO grupoDAO = new GrupoDAO();

			long id = Long.parseLong(request.getParameter("id").trim());

			Grupo grupo = grupoDAO.find(id);

			request.setAttribute("grupo", grupo);

			request.getRequestDispatcher("/view/admin/grupo_form.jsp").forward(request, response);					
		} catch (Exception e) {
			
			response.getWriter().append("Error: " + e.getMessage());
		}
	}

}
