package br.iss.ecommerce.servlet.adm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.iss.ecommerce.dao.ItemGradeDAO;
import br.iss.ecommerce.domain.Grade;
import br.iss.ecommerce.domain.ItemGrade;


@WebServlet("/adm/itemgrade/delete")
public class ItemGrade_Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ItemGrade_Delete() {
        
    	super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Recupera o id.
		long id = Long.parseLong(request.getParameter("id").trim());
		
		// Cria as classes DAO.
		ItemGradeDAO itemGradeDAO = new ItemGradeDAO();
		
		// Encontra o item correspondente no banco.
		ItemGrade itemGrade = itemGradeDAO.find(id);
		
		// Armazena o id da grade.
		long grade_id = itemGrade.getGrade().getId();
		
		// Exclúi a grade do banco.
		itemGradeDAO.delete(itemGrade);
		
		// Seta a mensagem de sucesso.
		request.getSession().setAttribute("flash_message_text", "Item de Grade excluído com sucesso.");
		request.getSession().setAttribute("flash_message_kind", "success");
		
		// Redireciona para a lista de grades.
		response.sendRedirect(request.getAttribute("base_url") + "/adm/grade/edit?id=" + grade_id);  		
	}

}
