package br.iss.ecommerce.servlet.adm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.iss.ecommerce.domain.Grupo;

@WebServlet("/adm/grupo/create")
public class Grupo_Create extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Grupo_Create() {
        
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("page_title", 				"Grupo");
		request.setAttribute("page_description", 		"Novo Grupo.");				
		
		Grupo grupo = new Grupo();
		request.setAttribute("grupo", grupo);

		request.getRequestDispatcher("/view/admin/grupo_form.jsp").forward(request, response);
	}

}
