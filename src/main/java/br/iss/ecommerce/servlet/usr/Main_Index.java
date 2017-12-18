package br.iss.ecommerce.servlet.usr;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.iss.ecommerce.dao.ProdutoDAO;
import br.iss.ecommerce.domain.Produto;

/**
 * Servlet implementation class Inicio
 */
@WebServlet("")
public class Main_Index extends HttpServlet {

	private static final long serialVersionUID = 1L;

    public Main_Index() {
        
    	super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Define classes DAO.
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		// Define objetos de persistência.
		List<Produto> produtos = produtoDAO.listAvaiable();
		
		// Seta atributos da chamada.
		request.setAttribute("produtos", produtos);
		
		// Chama a view.
		request.getRequestDispatcher("/view/user/main.jsp").forward(request, response);
	}

}
