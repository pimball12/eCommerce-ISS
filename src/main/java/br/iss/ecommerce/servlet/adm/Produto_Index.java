package br.iss.ecommerce.servlet.adm;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.iss.ecommerce.dao.ProdutoDAO;
import br.iss.ecommerce.domain.Produto;


@WebServlet("/adm/produto")
public class Produto_Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Produto_Index() {
        
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Passa as informações básicas da página.
		request.setAttribute("page_title", 				"Produtos");
		request.setAttribute("page_description", 		"Listagem de Produtos.");		
		
		// Passa os parâmetros do modal de delete.
		request.setAttribute("delete_modal_message",	"Deseja realmente excluír o produto?");
		request.setAttribute("delete_modal_url",		"/adm/produto/delete");
		
		// Passa os scripts necessários.
		String[] scripts = {"public/delete_button.js"};
		request.setAttribute("scripts", scripts);
		
		// Recupera os produtos.
		ProdutoDAO produtoDAO = new ProdutoDAO();
		List<Produto> produtos = produtoDAO.list();
		
		// Passa os dados para a view.
		request.setAttribute("produtos", produtos);
		
		// Chama a View.
		request.getRequestDispatcher("/view/admin/produto_index.jsp").forward(request, response);		
	}

}
