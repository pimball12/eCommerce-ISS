package br.iss.ecommerce.servlet.adm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.iss.ecommerce.domain.Grade;
import br.iss.ecommerce.domain.ItemGrade;
import br.iss.ecommerce.dao.GrupoDAO;
import br.iss.ecommerce.dao.GradeDAO;

import java.util.List;

/**
 * Servlet implementation class Grupo_Grade_Link
 */
@WebServlet("/adm/grupo/grade/link")
public class Grupo_Grade_Link extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Grupo_Grade_Link() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Passa as informações básicas da página.
		request.setAttribute("page_title", 				"Grupo");
		request.setAttribute("page_description", 		"Associar Grade ao Grupo.");				
		
		// Passa os arquivos .js e .css necessários.
		String[] scripts = {
			"plugins/select2/select2.full.min.js", 
			"public/select2.js",
		};
		request.setAttribute("scripts", scripts);
		
		String[] styles = {"plugins/select2/select2.min.css"};
		request.setAttribute("styles", styles); 			
		
		// Recupera o id da grade.
		long grupo_id = Long.parseLong(request.getParameter("grupo_id").trim());
		
		// Cria um item de grade vazio.
		List<Grade> grades = new GradeDAO().list();
		
		request.setAttribute("grupo_id", grupo_id);
		request.setAttribute("grades", grades);
		request.getRequestDispatcher("/view/admin/grupo_grade_link.jsp").forward(request, response);
	}

}
