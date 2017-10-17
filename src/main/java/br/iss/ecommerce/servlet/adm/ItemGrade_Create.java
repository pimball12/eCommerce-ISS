package br.iss.ecommerce.servlet.adm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.iss.ecommerce.domain.Grade;
import br.iss.ecommerce.domain.ItemGrade;



@WebServlet("/adm/itemgrade/create")
public class ItemGrade_Create extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    public ItemGrade_Create() {
        
    	super(); 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Passa as informações básicas da página.
		request.setAttribute("page_title", 				"Item de Grade");
		request.setAttribute("page_description", 		"Novo Item de Grade.");				
		
		// Recupera o id da grade.
		long grade_id = Long.parseLong(request.getParameter("grade_id").trim());
		
		// Cria um item de grade vazio.
		ItemGrade itemGrade = new ItemGrade();
		
		// Passa os dados para a view.
		request.setAttribute("itemGrade", itemGrade);
		request.setAttribute("grade_id", grade_id);
		
		// Chama a View.
		request.getRequestDispatcher("/view/admin/itemgrade_form.jsp").forward(request, response);
	}

}
