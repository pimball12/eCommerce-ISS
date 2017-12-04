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

/**
 * Servlet implementation class Grupo_Grade_Unlink
 */
@WebServlet("/grupo/grade/unlink")
public class Grupo_Grade_Unlink extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Grupo_Grade_Unlink() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GrupoDAO grupoDAO = new GrupoDAO();
		List<Grupo> grupos = grupoDAO.find(id);
	}

}
