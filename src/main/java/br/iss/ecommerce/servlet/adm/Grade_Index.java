package br.iss.ecommerce.servlet.adm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.iss.ecommerce.dao.GenericDAO;
import br.iss.ecommerce.domain.Endereco;

@WebServlet("/adm/grade")
public class Grade_Index extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
        
    public Grade_Index() {
    	
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Endereco endereco = new Endereco();
		endereco.setRua("Umuarama");
		request.setAttribute("teste", endereco);		
		
		// Passa as informações básicas da página.
		request.setAttribute("page_title", 			"Grades");
		request.setAttribute("page_description", 	"Listagem de Grades.");		
		
//		String[] scripts = {"hello", "world"};
//		request.setAttribute("scripts", scripts);
//		
//		String[] styles = {"hello", "world"};
//		request.setAttribute("styles", styles);
		
		// Chama a View.
		request.getRequestDispatcher("/view/admin/grade_index.jsp").forward(request, response);
	}

}
