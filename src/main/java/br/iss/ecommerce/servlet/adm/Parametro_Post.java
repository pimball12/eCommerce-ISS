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


@WebServlet("/adm/parametro/post")
public class Parametro_Post extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Parametro_Post() {
        
    	super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ParametroDAO parametroDAO 			= new ParametroDAO(); 
		Parametro parametro;
		
		long 	id 			= Long.parseLong(request.getParameter("id").trim());
		long	parametro_id 	= Long.parseLong(request.getParameter("parametro_id").trim());
		String 	valor		= request.getParameter("itemparametro_valor");
		
		request.getSession().setAttribute("flash_message_kind", "success");
		response.sendRedirect(	request.getAttribute("base_url") + 
								"/adm/parametro/edit?id=" + parametro_id); 
	}

}
