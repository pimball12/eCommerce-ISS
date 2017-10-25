package br.iss.ecommerce.servlet.adm;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.iss.ecommerce.dao.GrupoDAO;
import br.iss.ecommerce.domain.Grupo;


@WebServlet("/adm/grupo")
public class Grupo_Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Grupo_Index() {
        
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("page_title", 				"Grupos");
		request.setAttribute("page_description", 		"Listagem de Grupos.");		
		request.setAttribute("delete_modal_message",	"Deseja realmente excluír a gradeupo e todos os seus itens ?");
		request.setAttribute("delete_modal_url",		"/adm/grupo/delete");

		String[] scripts = {"delete_button.js"};
		request.setAttribute("scripts", scripts);

		GrupoDAO grupoDAO = new GrupoDAO();
		List<Grupo> grupos = grupoDAO.list();

		request.setAttribute("grades", grupos);
		request.getRequestDispatcher("/view/admin/grupo_index.jsp").forward(request, response);
	}

}
