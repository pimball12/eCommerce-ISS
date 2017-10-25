package br.iss.ecommerce.servlet.adm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.iss.ecommerce.dao.GradeDAO;
import br.iss.ecommerce.dao.ParametroDAO;
import br.iss.ecommerce.domain.Grade;
import br.iss.ecommerce.domain.Parametro;


@WebServlet("/adm/parametro/edit")
public class Parametro_Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Parametro_Edit() {
        
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			request.setAttribute("page_title", 			"Parametros");
			request.setAttribute("page_description", 	"Parametros gerais do sistema.");		
			
			ParametroDAO parametroDAO = new ParametroDAO();
			Parametro parametro = parametroDAO.getFirstOrDefault();

			request.setAttribute("parametro", parametro);
			request.getRequestDispatcher("/view/admin/parametro_form.jsp").forward(request, response);					
		} catch (Exception e) {
			response.getWriter().append("Error: " + e.getMessage());
		}
	}

}
