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


@WebServlet("/adm/itemgrade/post")
public class ItemGrade_Post extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    public ItemGrade_Post() {
        
    	super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Cria os objetos DAO.
		GradeDAO gradeDAO 			= new GradeDAO(); 
		ItemGradeDAO itemGradeDAO 	= new ItemGradeDAO();
		
		// Define os objetos de Persistência.
		ItemGrade itemGrade;
		Grade grade;
		
		// Recupera as propriedades da grade.
		long 	id 			= Long.parseLong(request.getParameter("id").trim());
		long	grade_id 	= Long.parseLong(request.getParameter("grade_id").trim());
		String 	valor		= request.getParameter("itemgrade_valor");
		
		// Verifica se é inserção ou atualização. No caso de inserção, associa a grade correspondente.
		if (id == 0)	{		
			itemGrade 	= new ItemGrade();
			grade 		= gradeDAO.find(grade_id); 
			itemGrade.setGrade(grade);
		} else	{
			itemGrade = itemGradeDAO.find(id);
		}
		
		// Passa os outros atributos. 
		itemGrade.setValor(valor);
		
		// Salva o item.
		if (id == 0)	
			itemGradeDAO.save(itemGrade);
		else
			itemGradeDAO.update(itemGrade);
			
		// Redireciona para a tela de edição daquela grade.
		response.sendRedirect(	request.getAttribute("base_url") + 
								"/adm/grade/edit?id=" + grade_id); 
	}

}
