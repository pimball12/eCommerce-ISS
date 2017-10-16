package br.iss.ecommerce.servlet.adm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.iss.ecommerce.dao.GradeDAO;
import br.iss.ecommerce.dao.ItemGradeDAO;
import br.iss.ecommerce.domain.Grade;
import br.iss.ecommerce.domain.ItemGrade;
import br.iss.ecommerce.util.HibernateUtil;


@WebServlet("/adm/grade/delete")
public final class Grade_Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Grade_Delete() {
        
    	super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Recupera o id.
		long id = Long.parseLong(request.getParameter("id").trim());
		
		// Cria as classes DAO.
		GradeDAO gradeDAO = new GradeDAO();
		
		// Encontra o item correspondente no banco e fecha a transação.
		Grade grade = gradeDAO.find(id);
		
		// Exclúi a grade do banco.
		gradeDAO.delete(grade);
		
		// Redireciona para a lista de grades.
		response.sendRedirect(request.getAttribute("base_url") + "/adm/grade");  
	}

}
