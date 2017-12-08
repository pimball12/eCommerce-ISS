package br.iss.ecommerce.servlet.usr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.iss.ecommerce.dao.ProdutoDAO;
import br.iss.ecommerce.domain.Imagem;
import br.iss.ecommerce.domain.Produto;


@WebServlet("/produto")
public class Produto_Show extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Produto_Show() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Define classes DAO.
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		// Pega o código do produto.
		long id = Long.parseLong(request.getParameter("id").trim());		
		
		// Define objetos de persistência. 
		Produto produto 		= produtoDAO.find(id);
		
		// Seta atributos da chamada.
		request.setAttribute("produto", produto); 
		
		// Chama a view.
		request.getRequestDispatcher("/view/user/produto.jsp").forward(request, response);   
	}

}
