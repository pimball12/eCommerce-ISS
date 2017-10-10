package br.iss.ecommerce.servlet.adm;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Hibernate;

import br.iss.ecommerce.dao.GradeDAO;
import br.iss.ecommerce.domain.Grade;
import br.iss.ecommerce.util.HibernateUtil;

@WebServlet("/adm/grade")
public class Grade_Index extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
        
    public Grade_Index() {
    	
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		// Passa as informações básicas da página.
		request.setAttribute("page_title", 				"Grades");
		request.setAttribute("page_description", 		"Listagem de Grades.");		
		
		// Passa os parâmetros do modal de delete.
		request.setAttribute("delete_modal_message",	"Deseja realmente excluír a grade e todos os seus itens ?");
		request.setAttribute("delete_modal_url",		"/adm/grade/delete");
		
		// Passa os scripts necessários.
		String[] scripts = {"delete_button.js"};
		request.setAttribute("scripts", scripts);
		
		// Recupera as grades.
		GradeDAO gradeDAO = new GradeDAO();
		List<Grade> grades = gradeDAO.list();
		
		// Passa os dados para a view.
		request.setAttribute("grades", grades);
		
		// Chama a View.
		request.getRequestDispatcher("/view/admin/grade_index.jsp").forward(request, response);
		
		// Fecha a sessao do hibernate.
		HibernateUtil.getSessionFactory().getCurrentSession().close();
	}

}
