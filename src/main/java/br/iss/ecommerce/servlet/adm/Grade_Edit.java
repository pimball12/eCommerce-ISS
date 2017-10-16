package br.iss.ecommerce.servlet.adm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.iss.ecommerce.dao.GradeDAO;
import br.iss.ecommerce.domain.Grade;


@WebServlet("/adm/grade/edit")
public class Grade_Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Grade_Edit() {
        
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			// Passa as informações básicas da página.
			request.setAttribute("page_title", 				"Grades");
			request.setAttribute("page_description", 		"Editar Grade.");	
			
			// Passa os parâmetros do modal de delete.
			request.setAttribute("delete_modal_message",	"Deseja realmente excluír este item de grade ?");
			request.setAttribute("delete_modal_url",		"/adm/itemgrade/delete");			
			
			// Passa os scripts necessários.
			String[] scripts = {"delete_button.js"};
			request.setAttribute("scripts", scripts); 
			
			// Instancia objetos DAO.
			GradeDAO gradeDAO = new GradeDAO();
			
			// Pega o código da grade.
			long id = Long.parseLong(request.getParameter("id").trim());
			
			// Recupera a grade.
			Grade grade = gradeDAO.find(id);
			
			// Passa os dados para a view.
			request.setAttribute("grade", grade);
			
			// Chama a View.
			request.getRequestDispatcher("/view/admin/grade_form.jsp").forward(request, response);					
		} catch (Exception e) {
			
			response.getWriter().append("Error: " + e.getMessage());
		}
	}

}
