package br.iss.ecommerce.servlet.adm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.iss.ecommerce.dao.GradeDAO;
import br.iss.ecommerce.domain.Grade;
import br.iss.ecommerce.util.HibernateUtil;


@WebServlet("/adm/grade/post")
public class Grade_Post extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Grade_Post() {
        
    	super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Cria os objetos DAO.
		GradeDAO gradeDAO = new GradeDAO();
		
		// Define os objetos de Persistência.
		Grade grade;
		
		// Recupera as propriedades da grade.
		long 	id 		= Long.parseLong(request.getParameter("id").trim());
		String 	nome	= request.getParameter("grade_nome");
		
		// Verifica se é inserção ou atualização.
		if (id == 0)			
			grade = new Grade();
		else 			
			grade = gradeDAO.find(id);		
		
		// Passa os outros atributos. 
		grade.setNome(nome);
		
		// Salva o item.
		if (id == 0)	
			gradeDAO.save(grade);
		else
			gradeDAO.update(grade);
			
		// Redireciona para a tela de edição daquela grade.
		response.sendRedirect(	request.getAttribute("base_url") + 
								"/adm/grade/edit?id=" + grade.getId());  		
	}

}
