package br.iss.ecommerce.servlet.adm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.iss.ecommerce.dao.ProdutoDAO;
import br.iss.ecommerce.domain.Produto;


@WebServlet("/adm/produto/delete")
public class Produto_Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public Produto_Delete() {
        
    	super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Recupera o id.
		long id = Long.parseLong(request.getParameter("id").trim());
		
		// Cria as classes DAO.
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		// Encontra o item correspondente no banco e fecha a transação.
		Produto produto = produtoDAO.find(id);
		
		// Exclúi a produto do banco.
		produtoDAO.delete(produto);
		
		// Seta a mensagem de sucesso.
		request.getSession().setAttribute("flash_message_text", "Produto excluído com sucesso.");
		request.getSession().setAttribute("flash_message_kind", "success");
		
		// Redireciona para a lista de produtos.
		response.sendRedirect(request.getAttribute("base_url") + "/adm/produto");  	
	}

}
