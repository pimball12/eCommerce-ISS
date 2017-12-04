package br.iss.ecommerce.servlet.adm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.iss.ecommerce.dao.GradeDAO;
import br.iss.ecommerce.dao.GrupoDAO;
import br.iss.ecommerce.domain.Grade;
import br.iss.ecommerce.domain.Grupo;
import br.iss.ecommerce.domain.ItemGrade;

/**
 * Servlet implementation class Grupo_Grade_Link_Post
 */
@WebServlet("/adm/grupo/grade/link/post")
public class Grupo_Grade_Link_Post extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Grupo_Grade_Link_Post() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Cria os objetos DAO.
		GrupoDAO grupoDAO = new GrupoDAO(); 
		GradeDAO gradeDAO = new GradeDAO();
		
		// Recupera as propriedades da grade.
		long grupo_id = Long.parseLong(request.getParameter("grupo_id").trim());
		long grade_id = Long.parseLong(request.getParameter("grade_id").trim());
		
		// Define os objetos de Persistência.		
		Grade grade = gradeDAO.find(grade_id);
		Grupo grupo = grupoDAO.find(grupo_id);
		
		grupo.getGrades().add(grade);
		
		grupoDAO.update(grupo);
		
		// Seta o tipo de mensagem como sucesso e redireciona para a tela de edição da grade daquele item.
		request.getSession().setAttribute("flash_message_kind", "success");
		response.sendRedirect(	request.getAttribute("base_url") + 
								"/adm/grupo/edit?id=" + grupo_id); 
	}

}
