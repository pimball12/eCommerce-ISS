package br.iss.ecommerce.servlet.adm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.iss.ecommerce.dao.ItemGradeDAO;
import br.iss.ecommerce.domain.ItemGrade;


@WebServlet("/adm/itemgrade/edit")
public class ItemGrade_Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    public ItemGrade_Edit() {
        
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Passa as informações básicas da página.
		request.setAttribute("page_title", 				"Item de Grade");
		request.setAttribute("page_description", 		"Editar Item de Grade.");
		
		// Instancia objetos DAO.
		ItemGradeDAO itemGradeDAO = new ItemGradeDAO();
		
		// Pega o código do item de grade.
		long id 		= Long.parseLong(request.getParameter("id").trim());
		long grade_id 	= Long.parseLong(request.getParameter("grade_id").trim());
		
		// Recupera o item de grade.
		ItemGrade itemGrade = itemGradeDAO.find(id);
		
		// Passa os dados para a view.
		request.setAttribute("itemGrade", itemGrade);
		request.setAttribute("grade_id", grade_id);
		
		// Chama a View.
		request.getRequestDispatcher("/view/admin/itemgrade_form.jsp").forward(request, response);		
	}

}
