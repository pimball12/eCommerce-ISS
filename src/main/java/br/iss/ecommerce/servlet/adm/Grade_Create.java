package br.iss.ecommerce.servlet.adm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.iss.ecommerce.domain.Grade;


@WebServlet("/adm/grade/create")
public class Grade_Create extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Grade_Create() {
        
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Passa as informações básicas da página.
		request.setAttribute("page_title", 				"Grades");
		request.setAttribute("page_description", 		"Nova Grade.");				
		
		// Cria uma grade vazia.
		Grade grade = new Grade();
		
		// Passa os dados para a view.
		request.setAttribute("grade", grade);
		
		// Chama a View.
		request.getRequestDispatcher("/view/admin/grade_form.jsp").forward(request, response);
	}

}
